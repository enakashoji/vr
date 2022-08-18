package br.com.nk.vr.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nk.vr.model.Cartao;
import br.com.nk.vr.model.Transacao;
import br.com.nk.vr.model.dto.CartaoDto;
import br.com.nk.vr.model.dto.TransacaoDto;
import br.com.nk.vr.repository.CartaoRepository;

public interface CartaoService {

	public boolean cartaoExiste(String numeroCartao);

	public void registrarOperacao(CartaoDto cartaoDto, BigDecimal valor);

	public boolean validaSenha(CartaoDto cartaoDto);

	public CartaoDto criarCartao(CartaoDto cartaoDto);

	public BigDecimal consultarSaldo(String numeroCartao);
}
