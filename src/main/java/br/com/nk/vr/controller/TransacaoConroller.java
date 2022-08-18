package br.com.nk.vr.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nk.vr.model.dto.TransacaoResponse;

@RestController
public class TransacaoConroller {

	@PostMapping("/transacoes")
	public TransacaoResponse transacoes() {
		TransacaoResponse result = new TransacaoResponse();
 		return result;
	}
}
