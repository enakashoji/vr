package br.com.nk.vr.model.dto;

import br.com.nk.vr.model.Cartao;

public class CartaoDto {
	private String numeroCartao;
	private String senha;
	
	public CartaoDto(String numeroCartao, String senha) {
		this.numeroCartao = numeroCartao;
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
		
	public static CartaoDto fromModel(Cartao cartao) {
		return new CartaoDto(cartao.getNumeroCartao(), cartao.getSenha());
	}
}
