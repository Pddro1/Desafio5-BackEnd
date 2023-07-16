package br.com.banco.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.banco.tipos.Tipos;
import lombok.Data;

@Entity
@Data
public class Transferencia {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataTransferencia;
	
	@Column(nullable = false)
	private double valor;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private Tipos tipo;
	
	@Column(nullable = false, length = 50)
	private String nomeOperadorTransacao;
	
	@Column(nullable = false)
	private int conta_id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

	public int getConta_id() {
		return conta_id;
	}

	public void setConta_id(int conta_id) {
		this.conta_id = conta_id;
	}
}
