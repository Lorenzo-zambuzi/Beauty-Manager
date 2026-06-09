package br.com.beautyManager.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/way")
public class BarraLateralWebController {

	@GetMapping("/index")
	public String wayIndex() {
		return "redirect:/index";
	}
	
	@GetMapping("/agendamento")
	public String wayAgendamento() {
		return "redirect:/agendamento/listar";
	}
	
	@GetMapping("/cliente")
	public String wayCliente() {
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/profissional")
	public String wayProfissional() {
		return "redirect:/profissional/listar";
	}
	
	@GetMapping("/servico")
	public String wayServico() {
		return "redirect:/servico/listar";
	}
}
