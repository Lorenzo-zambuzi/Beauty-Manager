package br.com.beautyManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautyManager.model.entity.Profissional;
import br.com.beautyManager.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public List<Profissional> listarTodos(){
		return profissionalRepository.findAll();
	}
	
	// id
	public Profissional buscarPorId(int id) {
		return profissionalRepository.findById(id).get();
	}
	
	// nome
	public Profissional buscarPorNome(String nome) {
		return profissionalRepository.findByNome(nome);
	}
	
	public List<Profissional> buscarPorNomeContem(String nome) {
		return profissionalRepository.findByNomeContains(nome);
	}
	
	//telefone
	public Profissional buscarPorTelefone(String telefone) {
		return profissionalRepository.findByTelefone(telefone);
	}
		
	public List<Profissional> buscarPorTelefoneContem(String telefone) {
		return profissionalRepository.findByTelefoneContains(telefone);
	}
	
	// email
	public Profissional buscarPorEmail(String email) {
		return profissionalRepository.findByEmail(email);
	}
	
	public List<Profissional> buscarPorEmailContem(String email) {
		return profissionalRepository.findByEmailContains(email);
	}
	
	// fucao
	public List<Profissional> buscarPorFuncao(String funcao) {
		return profissionalRepository.findByFuncao(funcao);
	}
		
	// salario
	public List<Profissional> buscarPorSalario(double salario) {
		return profissionalRepository.findBySalario(salario);
	}
	
	// salvar
	public Profissional salvarProfissional(Profissional profissional) {
		profissionalRepository.save(profissional);
		return profissional;
	}
	
	// deletar
	public void deletarProfissional(int id) {
		if(!buscarPorId(id).getFuncao().equals("gerente"))
			profissionalRepository.deleteById(id);
	}
}
