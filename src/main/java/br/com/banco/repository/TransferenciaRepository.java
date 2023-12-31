package br.com.banco.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	
	public Optional<List<Transferencia>> findByNomeOperadorTransacao(String nome);
	public List<Transferencia> findByDataTransferenciaBetween(LocalDate dataInicial, LocalDate dataFinal);

}
