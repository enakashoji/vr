package br.com.nk.vr.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nk.vr.model.Cartao;
import br.com.nk.vr.model.Transacao;
import br.com.nk.vr.model.dto.CartaoDto;
import br.com.nk.vr.repository.CartaoRepository;

public interface CartaoService {

	public boolean cartaoExiste(String numeroCartao);

	public void registrarOperacao(Cartao cartao, BigDecimal valor);

	public void autenticar(String numeroCartao, String senha);

	public CartaoDto criarCartao(CartaoDto cartaoDto);
}
