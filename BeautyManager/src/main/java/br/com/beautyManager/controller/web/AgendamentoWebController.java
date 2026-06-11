package br.com.beautyManager.controller.web;

import java.time.LocalDate;
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
	public String novoAgendamento(HttpSession session, Model model) {
		
		List<Profissional> cabeleireiros = new ArrayList<>();
		
		Profissional usuario = (Profissional) session.getAttribute("user");
		if(usuario.getFuncao().equals("cabeleireiro")) {
			cabeleireiros.add(usuario);
		}
		else {
			cabeleireiros = ps.buscarPorFuncao("cabeleireiro");
		}
		
		model
			.addAttribute("agendamento", new Agendamento())
			.addAttribute("novo", true)
			.addAttribute("cabeleireiros", cabeleireiros)
			.addAttribute("servicos", ss.listarTodos())
			.addAttribute("clientes", cs.listarTodos());
		
		return "FormularioAgendamento";
	}
	
	@GetMapping("/editar/{id}")
	public String editarAgendamento(HttpSession session, Model model, @PathVariable int id) {
		
		Agendamento agendamento = as.buscarPorId(id);
		List<Profissional> cabeleireiros = new ArrayList<>();
		
		Profissional usuario = (Profissional) session.getAttribute("user");
		if(usuario.getFuncao().equals("cabeleireiro")) {
			cabeleireiros.add(usuario);
		}
		else {
			cabeleireiros = ps.buscarPorFuncao("cabeleireiro");
		}
		
		model
			.addAttribute("agendamento", agendamento)
			.addAttribute("novo", false)
			.addAttribute("cabeleireiros", cabeleireiros)
			.addAttribute("servicos", ss.listarTodos())
			.addAttribute("clientes", cs.listarTodos());
		
		return "FormularioAgendamento";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarAgendamento(Model model, @PathVariable int id) {
		
		as.deletarAgendamento(id);
		
		return"redirect:/agendamento/listar";
	}
	
	/*
	 
	 */
	
	@PostMapping("/salvar")
	public String salvarAgendamento(Agendamento agendamento) {
		
		List<Agendamento> agenda = as.buscarPorProfissional(agendamento.getIdProfissional());
		
		for (Agendamento ag : agenda) {
			if(agendamento.getData().equals(ag.getData()) && agendamento.getHorario().equals(ag.getHorario()))
				return "redirect:/agendamento/listar";
		}
		
		as.salvarAgendamento(agendamento);
		return "redirect:/agendamento/listar";
	}
	
	@PostMapping("/salvar/novo")
	public String salvarNovoAgendamento(Agendamento agendamento) {
		
		List<Agendamento> agenda = as.buscarPorProfissional(agendamento.getIdProfissional());
		
		for (Agendamento ag : agenda) {
			if(agendamento.getData().equals(ag.getData()) && agendamento.getHorario().equals(ag.getHorario()))
				return "redirect:/agendamento/listar";
		}
		
		if(!agendamento.getData().isBefore(LocalDate.now())) {
			as.salvarAgendamento(agendamento);
		}
		return "redirect:/agendamento/listar";
	}
	
	@GetMapping("/listar")
	public String listarProfissionais(HttpSession session, Model model) {
		
		Profissional usuario = (Profissional) session.getAttribute("user");
		List<Agendamento> agendamentos = new ArrayList<>();
		
		if(usuario.getFuncao().equals("cabeleireiro")) 
			agendamentos = as.buscarPorProfissional(usuario.getIdProfissional());
		else
			agendamentos = as.listarTodos();
		
		
		model
			.addAttribute("agendamentos",agendamentos)
			.addAttribute("cabeleireiros", ps.buscarPorFuncao("cabeleireiro"))
			.addAttribute("servicos", ss.listarTodos())
			.addAttribute("clientes", cs.listarTodos());
		
		return "ListaAgendamento";
	}
}
