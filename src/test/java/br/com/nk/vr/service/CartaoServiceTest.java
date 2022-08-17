package br.com.nk.vr.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.nk.vr.model.Cartao;

public class CartaoServiceTest {
	
	@Test
	public void deveValidarSeOCartaoExiste() {
		String numeroCartao = "123456";
		CartaoService service = new CartaoService();
		assertTrue(service.cartaoExiste(numeroCartao));
	}

	@Test
	public void deveValidarASenha() {
		
	}
	
	@Test
	public void deveValidarOSaldo() {
		Cartao cartao = new Cartao("12345", "123");
		BigDecimal valor = new BigDecimal(100);
		CartaoService service = new CartaoService();
		service.sacar(cartao, valor);
	}
}
