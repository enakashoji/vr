package br.com.nk.vr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nk.vr.model.Transacao;
import br.com.nk.vr.model.dto.TransacaoDto;
import br.com.nk.vr.service.TransacaoService;

@RestController
public class TransacaoController {
	
	@Autowired
	private TransacaoService service;
	
	@PostMapping(value = "/transacoes")
	public ResponseEntity<String> transacoes(@RequestBody TransacaoDto transacaoDto) {
		if (service.senhaInvalida(transacaoDto)) {
			return new ResponseEntity<String>(Transacao.SENHA_INVALIDA.name(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		else if (service.cartaoInexistente(transacaoDto)) {
			return new ResponseEntity<String>(Transacao.CARTAO_INEXISTENTE.name(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		else if (service.saldoInsuficiente(transacaoDto)) {
			return new ResponseEntity<String>(Transacao.SALDO_INSUFICIENTE.name(), HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			service.executaTransacao(transacaoDto);
			return new ResponseEntity<String>(Transacao.OK.name(), HttpStatus.CREATED);			
		}
	}
}
