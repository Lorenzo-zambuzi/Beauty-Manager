package br.com.beautyManager.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.beautyManager.model.entity.Cliente;
import br.com.beautyManager.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteWebController {
	
	@Autowired
	ClienteService cs;
	
	
	@GetMapping("/novo")
	public String novoCliente(Model model) {
		
		model
			.addAttribute("cliente", new Cliente())
			.addAttribute("novo", true);
		
		return "FormularioCliente";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCliente(Model model, @PathVariable int id) {
		
		Cliente cliente = cs.buscarPorId(id);
		
		model
			.addAttribute("cliente", cliente)
			.addAttribute("novo", false);
		
		return "FormularioCliente";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarCliente(Model model, @PathVariable int id) {
		
		cs.deletarCliente(id);
		
		return"redirect:/cliente/listar";
	}
	
	@PostMapping("/salvar")
	public String salvarCliente(Cliente cliente) {
		
		cs.salvarCliente(cliente);
		
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/listar")
	public String listarProficsionais(Model model) {
		
		List<Cliente> clientes = cs.listarTodos();
		model.addAttribute("clientes",clientes);
		
		return "ListaCliente";
	}
}
