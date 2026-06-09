package br.com.beautyManager.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.beautyManager.model.entity.Agendamento;
import br.com.beautyManager.service.AgendamentoService;
import br.com.beautyManager.service.ClienteService;
import br.com.beautyManager.service.ProfissionalService;
import br.com.beautyManager.service.ServicoService;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoWebController {
	
	@Autowired
	AgendamentoService as;
	@Autowired
	ClienteService cs;
	@Autowired
	ProfissionalService ps;
	@Autowired
	ServicoService ss;
	
	
	@GetMapping("/novo")
	public String novoAgendamento(Model model) {
		
		model
			.addAttribute("agendamento", new Agendamento())
			.addAttribute("novo", true)
			.addAttribute("cabeleireiros", ps.buscarPorFuncao("cabeleireiro"))
			.addAttribute("servicos", ss.listarTodos())
			.addAttribute("clientes", cs.listarTodos());
		
		return "FormularioAgendamento";
	}
	
	@GetMapping("/editar/{id}")
	public String editarAgendamento(Model model, @PathVariable int id) {
		
		Agendamento agendamento = as.buscarPorId(id);
		
		model
			.addAttribute("agendamento", agendamento)
			.addAttribute("novo", false)
			.addAttribute("cabeleireiros", ps.buscarPorFuncao("cabeleireiro"))
			.addAttribute("servicos", ss.listarTodos())
			.addAttribute("clientes", cs.listarTodos());
		
		return "FormularioAgendamento";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarAgendamento(Model model, @PathVariable int id) {
		
		as.deletarAgendamento(id);
		
		return"redirect:/agendamento/listar";
	}
	
	@PostMapping("/salvar")
	public String salvarAgendamento(Agendamento agendamento) {
		
		as.salvarAgendamento(agendamento);
		
		return "redirect:/agendamento/listar";
	}
	
	@GetMapping("/listar")
	public String listarProfissionais(Model model) {
		
		List<Agendamento> agendamentos = as.listarTodos();
		model.addAttribute("agendamentos",agendamentos);
		
		return "ListaAgendamento";
	}
}
