package br.com.nk.vr.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nk.vr.model.dto.CartaoDto;
import br.com.nk.vr.service.CartaoService;

@RestController
public class CartaoController {
	
	@Autowired
	private CartaoService service;
	
	@PostMapping("/cartoes")
	public ResponseEntity<CartaoDto> criarCartao(@RequestBody CartaoDto cartaoDto) {
		if (service.cartaoExiste(cartaoDto.getNumeroCartao())) {
			return new ResponseEntity<CartaoDto>(cartaoDto, HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			return new ResponseEntity<CartaoDto>(service.criarCartao(cartaoDto), HttpStatus.CREATED);			
		}
		
	}
	
	@GetMapping("/cartoes/{numeroCartao}")
	public ResponseEntity<BigDecimal> consultaSaldo(@PathVariable String numeroCartao) {
		if (!service.cartaoExiste(numeroCartao)) {
			return ResponseEntity.notFound().build();
		}
		BigDecimal saldo = service.consultarSaldo(numeroCartao);
		return ResponseEntity.ok(saldo);
	}
}
