package br.com.beautyManager.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.beautyManager.model.entity.Agendamento;
import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.service.AgendamentoService;
import br.com.beautyManager.service.ClienteService;
import br.com.beautyManager.service.ProfissionalService;
import br.com.beautyManager.service.ServicoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/way")
public class BarraLateralWebController {

	@Autowired
	AgendamentoService as;
	@Autowired
	ClienteService cs;
	@Autowired
	ProfissionalService ps;
	@Autowired
	ServicoService ss;
	
	
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
	
	@GetMapping("/estatisticas")
	public String wayEstatisticas() {
		return "redirect:/estatistica";
	}
	
	@GetMapping("/out")
	public String wayOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
