package br.com.nk.vr.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.nk.vr.model.Cartao;

public class TransacaoServiceTest {

	@Test
	public void deveCriticarQuandoASenhaForInvalida() {
		String senha = "125";
		TransacaoService service = new TransacaoService();
		Cartao cartao = new Cartao("12345", "123");
		assertTrue(service.senhaValida(cartao, senha));
	}
	
	@Test
	public void deveCriticarQuandoOCartaoForInexistente() {
		
	}
	
	@Test
	public void deveCriticarQuandoOSaldoForInsuficiente() {
		
	}
}
