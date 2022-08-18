package br.com.nk.vr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nk.vr.model.dto.CartaoDto;
import br.com.nk.vr.service.CartaoService;

@RestController
public class CartaoController {
	
	private CartaoService service;
	
	public CartaoController(CartaoService service) {};

	@PostMapping("/cartoes")
	public ResponseEntity<CartaoDto> criarCartao(@RequestBody CartaoDto cartaoDto) {
		return ResponseEntity.ok(service.criarCartao(cartaoDto));
	}

//	@PutMapping("/{numeroCartao}")
//	public BigDecimal validaSenha() {
//		BigDecimal result = new BigDecimal(0.00);
//		return result;
//	}
//	
//	@GetMapping("/cartoes/{numeroCartao}")
//	public String consultaSaldo(@PathVariable Long numeroCartao) {
//		return "";
//	}
}
