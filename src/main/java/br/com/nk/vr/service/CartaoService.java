package br.com.nk.vr.service;

import java.math.BigDecimal;

import br.com.nk.vr.model.dto.CartaoDto;

public interface CartaoService {

	public boolean cartaoExiste(String numeroCartao);

	public void registrarOperacao(CartaoDto cartaoDto, BigDecimal valor);

	public boolean validaSenha(CartaoDto cartaoDto);

	public CartaoDto criarCartao(CartaoDto cartaoDto);

	public BigDecimal consultarSaldo(String numeroCartao);
}
