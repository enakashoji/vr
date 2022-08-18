package br.com.nk.vr.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.nk.vr.model.Cartao;
import br.com.nk.vr.model.dto.CartaoDto;
import br.com.nk.vr.repository.CartaoRepository;
import br.com.nk.vr.service.CartaoService;

@Service
public class CartaoServiceImpl implements CartaoService {

	private CartaoRepository repository;

	public CartaoDto criarCartao(CartaoDto cartaoDto) {
		Cartao cartaoSucesso = this.repository.save(new Cartao(cartaoDto.getNumeroCartao(), cartaoDto.getSenha()));
		return CartaoDto.fromModel(cartaoSucesso);
	}
	
	public CartaoServiceImpl(CartaoRepository repository) {
		this.repository = repository;
	};

	public boolean cartaoExiste(String numeroCartao) {
		Optional<Cartao> optionalCartao = repository.findById(numeroCartao);
		return optionalCartao.isPresent();
	}

	public void registrarOperacao(CartaoDto dto, BigDecimal valor) {
		repository.findById(dto.getNumeroCartao()).ifPresent(cartao -> {
			cartao.atualizarSaldo(valor);
			repository.save(cartao);			
		});
	}

	public boolean validaSenha(CartaoDto cartaoDto) {
		Optional<Cartao> cartao = repository.findById(cartaoDto.getNumeroCartao());
		return cartao.get().getNumeroCartao().equals(cartaoDto.getNumeroCartao());

	}

	public BigDecimal consultarSaldo(String numeroCartao) {
		Optional<Cartao> cartao = this.repository.findById(numeroCartao);
		return cartao.get().getSaldo();
	}

}
