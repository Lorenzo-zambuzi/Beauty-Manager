package br.com.beautyManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautyManager.model.entity.Cliente;
import br.com.beautyManager.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorId(int id) {
		return clienteRepository.findById(id).get();
	}
	
	// nome
	public Cliente buscarPorNome(String nome) {
		return clienteRepository.findByNome(nome);
	}
	
	public List<Cliente> buscarPorNomeContem(String nome) {
		return clienteRepository.findByNomeContains(nome);
	}
	
	//telefone
	public Cliente buscarPorTelefone(String telefone) {
		return clienteRepository.findByTelefone(telefone);
	}
	
	public List<Cliente> buscarPorTelefoneContem(String telefone) {
		return clienteRepository.findByTelefoneContains(telefone);
	}
	
	// email
	public Cliente buscarPorEmail(String email) {
		return clienteRepository.findByEmail(email);
	}
	
	public List<Cliente> buscarPorEmailContem(String email) {
		return clienteRepository.findByEmailContains(email);
	}
	
	
	// save
	public Cliente salvarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	// delete
	public void deletarCliente(int id) {
		clienteRepository.deleteById(id);
	}
}
