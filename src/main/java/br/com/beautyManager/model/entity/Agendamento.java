package br.com.beautyManager.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agenda")
public class Agendamento {

	// atributos
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAgendamento;
	private int idCliente;
	private int idProfissional;
	private int idServico;
	private LocalDate data;
	private LocalTime horario;
	
	// construtores
	public Agendamento() {}
	
	public Agendamento(int idAgendamento, int idCliente, int idProfissional, int idServico, LocalDate data, LocalTime horario,
			LocalTime termino) {
		super();
		this.idAgendamento = idAgendamento;
		this.idCliente = idCliente;
		this.idProfissional = idProfissional;
		this.idServico = idServico;
		this.data = data;
		this.horario = horario;
	}

	// getters e setters
	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	
}
