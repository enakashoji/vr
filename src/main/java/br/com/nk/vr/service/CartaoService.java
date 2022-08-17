package br.com.nk.vr.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nk.vr.model.Cartao;
import br.com.nk.vr.repository.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	public boolean cartaoExiste(String numeroCartao) {
		Optional<Cartao> optionalCartao = repository.findById(numeroCartao);
		return false;
	}

	public void sacar(Cartao cartao, BigDecimal valor) {
		cartao.atualizarSaldo(valor);
		repository.save(cartao);
	}

	private void validaSenha(String numeroCartao, String senha) {
		// TODO Auto-generated method stub
		
	}

}
