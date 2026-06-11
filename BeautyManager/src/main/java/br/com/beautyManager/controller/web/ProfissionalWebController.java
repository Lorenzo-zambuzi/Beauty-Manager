package br.com.beautyManager.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.beautyManager.model.entity.Agendamento;
import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.service.AgendamentoService;
import br.com.beautyManager.service.ClienteService;
import br.com.beautyManager.service.ProfissionalService;
import br.com.beautyManager.service.ServicoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/profissional")
public class ProfissionalWebController {
	
	@Autowired
	ProfissionalService ps;
	@Autowired
	AgendamentoService as;
	
	
	@GetMapping("/novo")
	public String novoProfissional(Model model) {
		
		model
			.addAttribute("profissional", new Profissional())
			.addAttribute("novo", true);
		
		return "FormularioProfissional";
	}
	
	@GetMapping("/editar/{id}")
	public String editarProfissional(Model model, @PathVariable int id) {
		
		Profissional profissional = ps.buscarPorId(id);
		
		model
			.addAttribute("profissional", profissional)
			.addAttribute("novo", false);
		
		return "FormularioProfissional";
	}
	
	@GetMapping("/perfil/{id}")
	public String perfilProfissional(Model model, @PathVariable int id) {
		
		Profissional profissional = ps.buscarPorId(id);
		
		model
			.addAttribute("profissional", profissional)
			.addAttribute("novo", false);
		
		return "PerfilProfissional";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarProfissional(Model model, @PathVariable int id) {
		
		List<Agendamento> agenda = as.buscarPorProfissional(id);
		
		for(Agendamento agendamento: agenda) {
			as.deletarAgendamento(agendamento.getIdAgendamento());
		}
		ps.deletarProfissional(id);
		
		return"redirect:/profissional/listar";
	}
	
	@PostMapping("/salvar")
	public String salvarProfissional(HttpSession session, Profissional profissional) {
		
		if(ps.buscarPorEmail(profissional.getEmail()) == null)
			ps.salvarProfissional(profissional);
		
		Profissional usuario = (Profissional) session.getAttribute("user");
		if(!usuario.getFuncao().equals("gerente")) {
			return "redirect:/index";
		}	
		
		
		if(usuario.getIdProfissional() == profissional.getIdProfissional())
			session.setAttribute("user", profissional);
		
		return "redirect:/profissional/listar";
	}
	
	@GetMapping("/listar")
	public String listarProfissionais(HttpSession session, Model model) {
		
		Profissional usuario = (Profissional) session.getAttribute("user");
		
		if(!usuario.getFuncao().equals("gerente")) {
			
			model
			.addAttribute("profissional", usuario)
			.addAttribute("novo", false);
			return "PerfilProfissional";
		}	
		
		List<Profissional> profissionais = ps.listarTodos();
		model.addAttribute("profissionais",profissionais);
		
		return "ListaProfissional";
	}
}
