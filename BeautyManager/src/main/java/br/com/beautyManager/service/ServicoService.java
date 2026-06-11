package br.com.beautyManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautyManager.model.entity.Servico;
import br.com.beautyManager.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> listarTodos(){
		return servicoRepository.findAll();
	}
	
	public Servico buscarPorId(int id) {
		return servicoRepository.findById(id).get();
	}
	
	public Servico buscarPorNome(String nome) {
		return servicoRepository.findByNome(nome);
	}
	
	public List<Servico> buscarPorNomeComeco(String nome) {
		return servicoRepository.findByNomeStartsWith(nome);
	}
	
	public List<Servico> buscarPorNomeContem(String nome) {
		return servicoRepository.findByNomeContains(nome);
	}
	
	public List<Servico> buscarPorNomeTermina(String nome) {
		return servicoRepository.findByNomeEndsWith(nome);
	}
	
	
	public Servico salvarServico(Servico servico) {
		servicoRepository.save(servico);
		return servico;
	}
	
	public void deletarServico(int id) {
		servicoRepository.deleteById(id);
	}
}
