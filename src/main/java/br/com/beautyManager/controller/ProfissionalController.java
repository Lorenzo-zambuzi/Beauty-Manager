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

import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.service.ProfissionalService;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalController {
	@Autowired
	private ProfissionalService profissionalService;
	
	// GET
	
	@GetMapping
	public List<Profissional> listarTodos(){
		return profissionalService.listarTodos();
	}
	
	// id
	@GetMapping("/{id}")
	public Profissional buscarPorId(@PathVariable int id){
		Profissional profissional = profissionalService.buscarPorId(id);
		return profissional;
	}
	
	
	// nome
	@GetMapping("/nome/{nome}")
	public Profissional buscarPorNome(@PathVariable String nome){
		Profissional profissional = profissionalService.buscarPorNome(nome);
		return profissional;
	}
	
	@GetMapping("/contem-nome/{nome}")
	public List<Profissional> buscarPorNomeContem(@PathVariable String nome){
		return profissionalService.buscarPorNomeContem(nome);
	}
	
	
	// telefone
	@GetMapping("/telefone/{telefone}")
	public Profissional buscarPortelefone(@PathVariable String telefone){
		Profissional profissional = profissionalService.buscarPorTelefone(telefone);
		return profissional;
	}
	
	@GetMapping("/contem-telefone/{telefone}")
	public List<Profissional> buscarPortelefoneContem(@PathVariable String telefone){
		return profissionalService.buscarPorTelefoneContem(telefone);
	}
	
	
	// email
	@GetMapping("/email/{email}")
	public Profissional buscarPorEmail(@PathVariable String email){
		Profissional profissional = profissionalService.buscarPorEmail(email);
		return profissional;
	}
	
	@GetMapping("/contem-email/{email}")
	public List<Profissional> buscarPorEmailContem(@PathVariable String email){
		return profissionalService.buscarPorEmailContem(email);
	}
	
	// funcao
	@GetMapping("/funcao/{funcao}")
	public List<Profissional> buscarPorFuncao(@PathVariable String funcao){
		return profissionalService.buscarPorFuncao(funcao);
	}
	
	// salario
	@GetMapping("/salario/{salario}")
	public List<Profissional> buscarPorSalario(@PathVariable double salario){
		return profissionalService.buscarPorSalario(salario);
	}
	
	// criar
	@PostMapping
	public Profissional insert(@RequestBody Profissional profissional) {
		profissionalService.salvarProfissional(profissional);
		return profissional;
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		profissionalService.deletarProfissional(id);
		return "Profissional deletado com sucesso!";
	}
	
	// Atualizar
	@PutMapping("/{id}")
	public Profissional atualizar(@RequestBody Profissional profissional, @PathVariable int id) {
		Profissional profissionalUpdate = profissionalService.buscarPorId(id);
		profissionalUpdate.setNome(profissional.getNome());
		profissionalUpdate.setEmail(profissional.getEmail());
		profissionalUpdate.setTelefone(profissional.getTelefone());
		profissionalUpdate.setFuncao(profissional.getEmail());
		profissionalUpdate.setTelefone(profissional.getTelefone());
		return profissionalService.salvarProfissional(profissionalUpdate);
	}
}
