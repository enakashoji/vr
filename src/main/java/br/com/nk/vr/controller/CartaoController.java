package br.com.nk.vr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nk.vr.model.dto.CartaoResponse;
import br.com.nk.vr.model.dto.TransacaoResponse;

@RestController
public class CartaoController {

	//	 * a criação de cartões (todo cartão deverá ser criado com um saldo inicial de R$500,00)
	//	 * a obtenção de saldo do cartão
	//	 * a autorização de transações realizadas usando os cartões previamente criados como meio de pagamento
	@PostMapping("/cartoes")
	public CartaoResponse criarCartao() {
		CartaoResponse result = new CartaoResponse();
		return result;
	}

	@PutMapping("/{numeroCartao}")
	public String validaSenha() {
		return "";
	}
	
	@GetMapping("/cartoes/{numeroCartao}")
	public String consultaSaldo() {
		return "";
	}
	
	@PostMapping("/transacoes")
	public TransacaoResponse transacoes() {
		TransacaoResponse result = new TransacaoResponse();
 		return result;
	}
}
