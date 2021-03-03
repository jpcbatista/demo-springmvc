package br.com.alura.mvc.mvcdemo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mvcdemo.model.Pedido;
import br.com.alura.mvc.mvcdemo.model.StatusPedido;
import br.com.alura.mvc.mvcdemo.repository.PedidoRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired //anotação que pede uma instancia para o spring inicializar
	private PedidoRepository pedidoRepository;
	
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName(), paginacao);
		model.addAttribute("pedidos", pedidos);
		
		return "usuario/pedidos-usuario";
	}
	
	@GetMapping("pedido/{status}")
	public String statusPedido(@PathVariable("status") String status, Model model, Principal principal) {
		
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName(), paginacao);
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		
		return "usuario/pedidos-usuario";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/pedidos-usuario";
	}

}
