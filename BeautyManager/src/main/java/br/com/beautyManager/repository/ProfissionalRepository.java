package br.com.beautyManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beautyManager.model.entity.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

	public Profissional findByNome(String nome);
	
	public List<Profissional> findByNomeContains(String nome);
	
	public Profissional findByTelefone(String telefone);
	
	public List<Profissional> findByTelefoneContains(String telefone);
	
	public Profissional findByEmail(String email);
	
	public List<Profissional> findByEmailContains(String email);
	
	public List<Profissional> findByFuncao(String funcao);
	
	public List<Profissional> findBySalario(double salario);
	
}