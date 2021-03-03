package br.com.alura.mvc.mvcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mvcdemo.model.Pedido;
import br.com.alura.mvc.mvcdemo.model.StatusPedido;
import br.com.alura.mvc.mvcdemo.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired //anotação que pede uma instancia para o spring inicializar
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model) {
		
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	
	}

}

