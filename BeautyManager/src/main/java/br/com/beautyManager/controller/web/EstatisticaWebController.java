package br.com.beautyManager.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.beautyManager.model.entity.Agendamento;
import br.com.beautyManager.model.entity.Cliente;
import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.model.entity.Servico;
import br.com.beautyManager.service.AgendamentoService;
import br.com.beautyManager.service.ClienteService;
import br.com.beautyManager.service.ProfissionalService;
import br.com.beautyManager.service.ServicoService;

@Controller
@RequestMapping("/estatistica")
public class EstatisticaWebController {
	
	@Autowired
	AgendamentoService as;
	@Autowired
	ClienteService cs;
	@Autowired
	ProfissionalService ps;
	@Autowired
	ServicoService ss;
	
	@GetMapping
	public String index(Model model) {
		
		Cliente mc = new Cliente();				// mc -> "melhor Cliente" -> cliente mais frequente (o mesmo vale para os abaixo)
		Profissional mp = new Profissional();	// mp -> "melhor Profissional"
		Servico ms = new Servico();				// ms -> "melhor Serviço"
		
		List<Cliente> clientesFrequentes = new ArrayList<Cliente>();
		List<Profissional> profissionaisFrequentes = new ArrayList<Profissional>();
		List<Servico> servicosFrequentes = new ArrayList<Servico>();
		
		double total = 0;
		
		
		
		
		if(!as.listarTodos().isEmpty()) {
			// clientes
			for (Cliente cliente : cs.listarTodos()) {
				
				if(as.buscarPorCliente(cliente.getIdCliente()).size() > as.buscarPorCliente(mc.getIdCliente()).size() || mc.equals(null)) {
					mc = cs.buscarPorId(cliente.getIdCliente());
				}
			}
	
			clientesFrequentes.add(mc);
			
			for (Cliente cliente : cs.listarTodos()) {
				
				if(as.buscarPorCliente(cliente.getIdCliente()).size() == as.buscarPorCliente(mc.getIdCliente()).size() && cliente.getIdCliente() != mc.getIdCliente()) {
					clientesFrequentes.add(cliente);
				}
			}
			
			
			// profissionais
			for (Profissional profissional : ps.listarTodos()) {
				
				if(as.buscarPorProfissional(profissional.getIdProfissional()).size() > as.buscarPorProfissional(mp.getIdProfissional()).size() || mp.equals(null)) {
					mp = ps.buscarPorId(profissional.getIdProfissional());
				}
			}
			
			profissionaisFrequentes.add(mp);
			
			for (Profissional profissional : ps.listarTodos()) {
				
				if(as.buscarPorProfissional(profissional.getIdProfissional()).size() == as.buscarPorProfissional(mp.getIdProfissional()).size() && profissional.getIdProfissional() != mp.getIdProfissional()) {
					profissionaisFrequentes.add(profissional);
				}
			}
			
			// servicos
			for (Servico servico : ss.listarTodos()) {
				
				if(as.buscarPorServico(servico.getIdServico()).size() > as.buscarPorServico(ms.getIdServico()).size() || ms.equals(null)) {
					ms = ss.buscarPorId(servico.getIdServico());
				}
			}
			
			servicosFrequentes.add(ms);
	
			for (Servico servico : ss.listarTodos()) {
				
				if(as.buscarPorServico(servico.getIdServico()).size() == as.buscarPorServico(ms.getIdServico()).size() && servico.getIdServico() != ms.getIdServico()) {
					servicosFrequentes.add(servico);
				}
			}
			
			// Total de dinheiro/preço
			for (Agendamento agendamento : as.listarTodos()) {
				total += ss.buscarPorId(agendamento.getIdServico()).getPreco();
			}
		}
		
		model
			.addAttribute("clientesFrequentes", clientesFrequentes)
			.addAttribute("profissionaisFrequentes", profissionaisFrequentes)
			.addAttribute("servicosFrequentes", servicosFrequentes)
			.addAttribute("total", total);
		
		return "Estatisticas";
	}

}
