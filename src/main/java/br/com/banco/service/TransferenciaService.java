package br.com.banco.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository repository;
	
	@Transactional
	public Transferencia save(Transferencia conta) {
		return repository.save(conta);
	}
	
	public List<Transferencia> findByDataTransferenciaBetween(@RequestParam String minDate, @RequestParam String maxDate) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findByDataTransferenciaBetween(min, max);
	}
	
	public Optional<Transferencia> findById(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	public Optional<List<Transferencia>> findByNomeOperadorTransacao(@PathVariable String nome) {
		return repository.findByNomeOperadorTransacao(nome);
	}
	
	@Transactional
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}