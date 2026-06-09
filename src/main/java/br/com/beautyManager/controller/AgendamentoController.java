package br.com.beautyManager.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beautyManager.model.entity.Agendamento;
import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.repository.AgendamentoRepository;
import br.com.beautyManager.service.AgendamentoService;

@RestController
@RequestMapping("api/agenda")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	
	// GET
	
	@GetMapping
	public List<Agendamento> listarTodos(){
		return agendamentoService.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public Agendamento buscarPorId(@PathVariable int id) {
		Agendamento agendamento = agendamentoService.buscarPorId(id);
		return agendamento;
	}
	
	@GetMapping ("data/{data}")
	public List<Agendamento> buscarPorData(@PathVariable LocalDate data){
		return agendamentoService.buscarPorData(data);
	}
	
	@GetMapping ("profissional/{profissional}")
	public List<Agendamento> buscarPorProfissional(@PathVariable int profissional){
		return agendamentoService.buscarPorProfissional(profissional);
	}
	
	@GetMapping ("cliente/{cliente}")
	public List<Agendamento> buscarPorCliente(@PathVariable int cliente){
		return agendamentoService.buscarPorCliente(cliente);
	}
	
	@GetMapping ("servico/{servico}")
	public List<Agendamento> buscarPorData(@PathVariable int servico){
		return agendamentoService.buscarPorServico(servico);
	}
	
	
	//	DELETE
	@DeleteMapping("/{id}")
	public String deletarAgendamento(@PathVariable int agendamento) {
		agendamentoService.deletarAgendamento(agendamento);
		return "Agendamento deletado com sucesso!";
	}
	
	//	POST
	@PostMapping
	public Agendamento salvarAgendamento(@RequestBody Agendamento agendamento) {
		agendamentoService.salvarAgendamento(agendamento);
		return agendamento;
	}
	
	//	UPDATE
	@PutMapping("/{id}")
	public Agendamento atualizar(@RequestBody Agendamento agendamento, @PathVariable int id) {
		Agendamento agendamentoUpdate = agendamentoService.buscarPorId(id);
		agendamentoUpdate.setIdCliente(agendamento.getIdCliente());
		agendamentoUpdate.setIdProfissional(agendamento.getIdCliente());
		agendamentoUpdate.setIdServico(agendamento.getIdServico());
		agendamentoUpdate.setData(agendamento.getData());
		agendamentoUpdate.setHorario(agendamento.getHorario());
		return agendamentoService.salvarAgendamento(agendamentoUpdate);
	}
}
