package br.com.nk.vr.service.utils;

import java.math.BigDecimal;

import br.com.nk.vr.model.Cartao;
import br.com.nk.vr.model.dto.CartaoDto;
import br.com.nk.vr.model.dto.TransacaoDto;

public class FactoryMock {

	private static final String CARTAO_SUCESSO = "12345";
	private static final String SENHA_SUCESSO = "123";
	public static Cartao criarCartaoSucesso() {
		return new Cartao(CARTAO_SUCESSO, SENHA_SUCESSO);
	}
	
	public static CartaoDto criarCartaoDtoSucesso() {
		return new CartaoDto(CARTAO_SUCESSO, SENHA_SUCESSO);
	}
	
	public static TransacaoDto transacaoDtoSucesso() {
		return new TransacaoDto(CARTAO_SUCESSO, SENHA_SUCESSO, new BigDecimal(10.00));
	}
}

