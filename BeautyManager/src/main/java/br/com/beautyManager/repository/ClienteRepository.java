package br.com.beautyManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beautyManager.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public Cliente findByNome(String nome);
	public List<Cliente> findByNomeContains(String nome);
	
	public Cliente findByTelefone(String telefone);
	
	public List<Cliente> findByTelefoneContains(String telefone);
	
	public Cliente findByEmail(String email);
	
	public List<Cliente> findByEmailContains(String email);
	
}