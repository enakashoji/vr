package br.com.nk.vr.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nk.vr.model.Cartao;
import br.com.nk.vr.model.dto.TransacaoDto;
import br.com.nk.vr.repository.CartaoRepository;
import br.com.nk.vr.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService{
	
	@Autowired
	private CartaoRepository cartaoRepository;

	@Override
	public TransacaoDto executaTransacao(TransacaoDto transacaoDto) {
		Optional<Cartao> cartao = cartaoRepository.findById(transacaoDto.getNumeroCartao());
		if (cartao.isPresent()) {	
			cartao.get().atualizarSaldo(transacaoDto.getValor());
			cartaoRepository.save(cartao.get());
		}
		return transacaoDto;
	}

	@Override
	public boolean saldoInsuficiente(TransacaoDto transacaoDto) {
		Optional<Cartao> cartao = cartaoRepository.findById(transacaoDto.getNumeroCartao());
		return (cartao.get().getSaldo().compareTo(transacaoDto.getValor()) == 1);
	}

	@Override
	public boolean senhaInvalida(TransacaoDto transacaoDto) {
		Optional<Cartao> cartao = cartaoRepository.findById(transacaoDto.getNumeroCartao());
		return (cartao.get().getSenha().equals(transacaoDto.getSenhaCartao()));
	}

	@Override
	public boolean cartaoInexistente(TransacaoDto transacaoDto) {
		Optional<Cartao> cartao = cartaoRepository.findById(transacaoDto.getNumeroCartao());
		return cartao.isPresent();
	}

}
