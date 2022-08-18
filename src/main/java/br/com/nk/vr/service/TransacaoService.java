package br.com.nk.vr.service;

import br.com.nk.vr.model.dto.TransacaoDto;

public interface TransacaoService {
	public TransacaoDto executaTransacao(TransacaoDto transacaoDto);
	public boolean saldoInsuficiente(TransacaoDto transacaoDto);
	public boolean senhaInvalida(TransacaoDto transacaoDto);
	public boolean cartaoInexistente(TransacaoDto transacaoDto);
}
