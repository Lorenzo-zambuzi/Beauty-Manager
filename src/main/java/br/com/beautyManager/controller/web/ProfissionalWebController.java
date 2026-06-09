package br.com.beautyManager.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.service.ClienteService;
import br.com.beautyManager.service.ProfissionalService;
import br.com.beautyManager.service.ServicoService;

@Controller
@RequestMapping("/profissional")
public class ProfissionalWebController {
	
	@Autowired
	ProfissionalService ps;
	
	
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
	
	@GetMapping("/deletar/{id}")
	public String deletarProfissional(Model model, @PathVariable int id) {
		
		ps.deletarProfissional(id);
		
		return"redirect:/profissional/listar";
	}
	
	@PostMapping("/salvar")
	public String salvarProfissional(Profissional profissional) {
		
		ps.salvarProfissional(profissional);
		
		return "redirect:/profissional/listar";
	}
	
	@GetMapping("/listar")
	public String listarProfissionais(Model model) {
		
		List<Profissional> profissionais = ps.listarTodos();
		model.addAttribute("profissionais",profissionais);
		
		return "ListaProfissional";
	}
}
