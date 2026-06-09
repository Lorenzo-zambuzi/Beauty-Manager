package br.com.beautyManager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicos")
public class Servico {

	// Atributos
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServico;
	private String nome;
	private double preco;
	
	// Construtores
	public Servico() {}
	
	public Servico(int idServico, String nome, double preco) {
		super();
		this.idServico = idServico;
		this.nome = nome;
		this.preco = preco;
	}

	// getters e setters
	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
