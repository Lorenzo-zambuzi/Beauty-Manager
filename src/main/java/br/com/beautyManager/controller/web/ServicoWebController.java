package br.com.beautyManager.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.beautyManager.model.entity.Servico;
import br.com.beautyManager.service.ClienteService;
import br.com.beautyManager.service.ServicoService;
import br.com.beautyManager.service.ServicoService;

@Controller
@RequestMapping("/servico")
public class ServicoWebController {
	
	@Autowired
	ServicoService ss;
	
	
	@GetMapping("/novo")
	public String novoServico(Model model) {
		
		model
			.addAttribute("servico", new Servico())
			.addAttribute("novo", true);
		
		return "FormularioServico";
	}
	
	@GetMapping("/editar/{id}")
	public String editarServico(Model model, @PathVariable int id) {
		
		Servico servico = ss.buscarPorId(id);
		
		model
			.addAttribute("servico", servico)
			.addAttribute("novo", false);
		
		return "FormularioServico";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarServico(Model model, @PathVariable int id) {
		
		ss.deletarServico(id);
		
		return"redirect:/servico/listar";
	}
	
	@PostMapping("/salvar")
	public String salvarServico(Servico servico) {
		
		ss.salvarServico(servico);
		
		return "redirect:/servico/listar";
	}
	
	@GetMapping("/listar")
	public String listarProfissionais(Model model) {
		
		List<Servico> servicos = ss.listarTodos();
		model.addAttribute("servicos",servicos);
		
		return "ListaServico";
	}
}
