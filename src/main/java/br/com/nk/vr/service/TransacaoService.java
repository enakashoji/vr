package br.com.nk.vr.service;

import br.com.nk.vr.model.Cartao;

public class TransacaoService {

	public boolean senhaValida(Cartao cartao, String senha) {
		if (cartao.getSenha().equalsIgnoreCase(senha)) {
			return true;
		}
		return false;
	}

}
