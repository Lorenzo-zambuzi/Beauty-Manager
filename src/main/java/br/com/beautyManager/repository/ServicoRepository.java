package br.com.beautyManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beautyManager.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	public Servico findByNome(String nome);
	
	public List<Servico> findByNomeStartsWith(String nome);
	public List<Servico> findByNomeEndsWith(String nome);
	public List<Servico> findByNomeContains(String nome);
	
}