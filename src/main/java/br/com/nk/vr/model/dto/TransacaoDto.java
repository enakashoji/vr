package br.com.nk.vr.model.dto;

import java.math.BigDecimal;

import br.com.nk.vr.model.Cartao;

public class TransacaoDto {

	private String numeroCartao;
	private String senhaCartao;
	private BigDecimal valor;
	
	public TransacaoDto(String numeroCartao, String senhaCartao, BigDecimal valor) {
		this.numeroCartao = numeroCartao;
		this.senhaCartao = senhaCartao;
		this.valor = valor;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getSenhaCartao() {
		return senhaCartao;
	}
	public void setSenhaCartao(String senhaCartao) {
		this.senhaCartao = senhaCartao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public static TransacaoDto fromModel(Cartao cartao) {
		return new TransacaoDto(cartao.getNumeroCartao(), cartao.getSenha(), cartao.getSaldo());
	}

}
