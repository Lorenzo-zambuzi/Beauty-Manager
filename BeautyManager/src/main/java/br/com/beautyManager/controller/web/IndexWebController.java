package br.com.beautyManager.controller.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.constructor.SafeConstructor.ConstructUndefined;

import br.com.beautyManager.model.entity.Agendamento;
import br.com.beautyManager.model.entity.Cliente;
import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.model.entity.Servico;
import br.com.beautyManager.service.AgendamentoService;
import br.com.beautyManager.service.ClienteService;
import br.com.beautyManager.service.ProfissionalService;
import br.com.beautyManager.service.ServicoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexWebController {
	
	@Autowired
	AgendamentoService as;
	@Autowired
	ClienteService cs;
	@Autowired
	ProfissionalService ps;
	@Autowired
	ServicoService ss;
	
	@GetMapping
	public String index( Model model, HttpSession session) {
		
		List<Agendamento> agendaHoje = new ArrayList<Agendamento>();
		List<Servico> servicosHoje = new ArrayList<Servico>();
		LocalDate hoje = LocalDate.now();
		double total = 0;
		
		// filtrar para não ter erro por falta de sessão
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		
		// vem depois para ter certeza de que não vai travar
		Profissional usuario = (Profissional) session.getAttribute("user");
		
		// filtrar agenda para o cabeleireiro
		if(usuario.getFuncao().equals("cabeleireiro")) {
			for (Agendamento agendamento : as.listarTodos()) {
				if(agendamento.getData().equals(hoje)) {
					if(agendamento.getIdProfissional() == usuario.getIdProfissional()) {
						agendaHoje.add(agendamento);
						//servicosHoje.add(ss.buscarPorId(agendamento.getIdServico()));
						total += ss.buscarPorId(agendamento.getIdServico()).getPreco();
					}
				}
			}
		}
		else {
			for (Agendamento agendamento : as.listarTodos()) {
				if(agendamento.getData().equals(hoje)) {
					agendaHoje.add(agendamento);
					//servicosHoje.add(ss.buscarPorId(agendamento.getIdServico()));
					total += ss.buscarPorId(agendamento.getIdServico()).getPreco();
				}
			}
		}
		
		model
			.addAttribute("agendaHoje", agendaHoje)
			.addAttribute("cabeleireiros", ps.buscarPorFuncao("cabeleireiro"))
			.addAttribute("servicos", ss.listarTodos())
			.addAttribute("clientes", cs.listarTodos())
			.addAttribute("total", total)
			//.addAttribute("servicosHoje", servicosHoje)
			.addAttribute("user", session.getAttribute("user"));
		
		return "Index";
	}
	
	

}
