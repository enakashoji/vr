package br.com.nk.vr.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cartao")
public class Cartao {
	
	@Id
	private String numeroCartao;
	private String senha;
	private BigDecimal saldo = new BigDecimal(500).setScale(2);
	
	public Cartao() {

	}
	
	public Cartao(String numeroCartao, String senha) {
		this.numeroCartao = numeroCartao;
		this.senha = senha;
	}
	
	public void atualizarSaldo(BigDecimal valor) {
		this.saldo = saldo.subtract(valor);
	}
		
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public String getSenha() {
		return senha;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(numeroCartao, other.numeroCartao);
	}

}
