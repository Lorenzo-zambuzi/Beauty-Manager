package br.com.beautyManager.service;

import java.time.*;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautyManager.model.entity.Agendamento;
import br.com.beautyManager.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> listarTodos(){
		return agendamentoRepository.findAll();
	}
	
	public Agendamento buscarPorId(int id) {
		return agendamentoRepository.findById(id).get();
	}
	
	
	//	data
	public List<Agendamento> buscarPorData(LocalDate data) {
		return agendamentoRepository.findByData(data);
	}
	
	public List<Agendamento> buscarPorHorario(LocalTime horario) {
		return agendamentoRepository.findByHorario(horario);
	}
	
	// idProfisional
	public List<Agendamento> buscarPorProfissional(int id) {
		return agendamentoRepository.findByIdProfissional(id);
	}
	
	// idCliente
	public List<Agendamento> buscarPorCliente(int id) {
		return agendamentoRepository.findByIdCliente(id);
	}
	
	// idServico
	public List<Agendamento> buscarPorServico(int id) {
		return agendamentoRepository.findByIdServico(id);
	}
	
	//	CRUD
	public Agendamento salvarAgendamento(Agendamento agendamento) {
		agendamentoRepository.save(agendamento);
		return agendamento;
	}
	
	public void deletarAgendamento(int id) {
		agendamentoRepository.deleteById(id);
	}
}
