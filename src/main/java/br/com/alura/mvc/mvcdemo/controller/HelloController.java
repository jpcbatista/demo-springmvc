package br.com.alura.mvc.mvcdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		
		request.setAttribute("nome", "mundo");
		
		return "hello";
	}
}

//Para chegar na pagina desejada, uma requisição que chega ao spring MVC 
//deve ser redirecionada ao nosso Controller que possui metodos "action"
//e o retorno desses metodos corresponde ao nome da view que precisa ser
//processada para gerar o html!