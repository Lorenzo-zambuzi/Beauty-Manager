package br.com.beautyManager.controller;

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

import br.com.beautyManager.model.entity.Cliente;
import br.com.beautyManager.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	// GET
	
	@GetMapping
	public List<Cliente> listarTodos(){
		return clienteService.listarTodos();
	}
	
	// id
	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable int id){
		Cliente cliente = clienteService.buscarPorId(id);
		return cliente;
	}
	
	
	// nome
	@GetMapping("/nome/{nome}")
	public Cliente buscarPorNome(@PathVariable String nome){
		Cliente cliente = clienteService.buscarPorNome(nome);
		return cliente;
	}
	
	@GetMapping("/contem-nome/{nome}")
	public List<Cliente> buscarPorNomeContem(@PathVariable String nome){
		return clienteService.buscarPorNomeContem(nome);
	}
	
	
	// telefone
	@GetMapping("/telefone/{telefone}")
	public Cliente buscarPortelefone(@PathVariable String telefone){
		Cliente cliente = clienteService.buscarPorTelefone(telefone);
		return cliente;
	}
	
	@GetMapping("/contem-telefone/{telefone}")
	public List<Cliente> buscarPortelefoneContem(@PathVariable String telefone){
		return clienteService.buscarPorTelefoneContem(telefone);
	}
	
	
	// email
	@GetMapping("/email/{email}")
	public Cliente buscarPorEmail(@PathVariable String email){
		Cliente cliente = clienteService.buscarPorEmail(email);
		return cliente;
	}
	
	@GetMapping("/contem-email/{email}")
	public List<Cliente> buscarPorEmailContem(@PathVariable String email){
		return clienteService.buscarPorEmailContem(email);
	}
	
	// criar
	@PostMapping
	public Cliente insert(@RequestBody Cliente cliente) {
		clienteService.salvarCliente(cliente);
		return cliente;
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		clienteService.deletarCliente(id);
		return "Cliente deletado com sucesso!";
	}
	
	// Atualizar
	@PutMapping("/{id}")
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable int id) {
		Cliente clienteUpdate = clienteService.buscarPorId(id);
		clienteUpdate.setNome(cliente.getNome());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefone(cliente.getTelefone());
		return clienteService.salvarCliente(clienteUpdate);
	}
}
