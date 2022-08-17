package br.com.nk.vr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.nk.vr.model.Cartao;

public class CartaoServiceTest {
	
//	@Test
//	public void deveValidarSeOCartaoExiste() {
//		Cartao cartao = new Cartao("12345", "123");
//		String numeroCartao = "123456";
//		CartaoService service = new CartaoService();
//		assertTrue(service.cartaoExiste(numeroCartao));
//	}

	@Test
	public void deveValidarASenha() {
		
	}
	
	@Test
	public void deveValidarOSaldo() {
		Cartao cartao = new Cartao("12345", "123");
		BigDecimal valor = new BigDecimal(100);
		BigDecimal saldo = new BigDecimal(400);
		CartaoService service = new CartaoService();
		service.registrarOperacao(cartao, valor);
		assertEquals(saldo.setScale(2), cartao.getSaldo());
	}
}
