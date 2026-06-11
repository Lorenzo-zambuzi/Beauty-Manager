package br.com.beautyManager.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beautyManager.model.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

	public List<Agendamento> findByData(LocalDate data);
	
	public List<Agendamento> findByHorario(LocalTime horario);
	
	public List<Agendamento> findByIdProfissional(int id);
	public List<Agendamento> findByIdCliente(int id);
	public List<Agendamento> findByIdServico(int id);
	
}