package br.com.banco.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	@Transactional
	public Conta save(Conta conta) {
		return repository.save(conta);
	}
	
	public List<Conta> findAll() {
		return repository.findAll();
	}
	
	public Optional<Conta> findById(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@Transactional
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}