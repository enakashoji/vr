package br.com.nk.vr.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.nk.vr.service.utils.FactoryMock;

public class TransacaoServiceTest {
	
	@MockBean
	private CartaoService cartaoSerive;
	
	@Autowired
	private TransacaoService service;
	
	@BeforeEach
	public void setup() {
		when(cartaoSerive.cartaoExiste(FactoryMock.transacaoDtoSucesso().getNumeroCartao())).thenReturn(false);
		when(cartaoSerive.consultarSaldo(FactoryMock.criarCartaoDtoSucesso().getNumeroCartao())).thenReturn(BigDecimal.ZERO);
	}

	@Test
	public void deveCriticarQuandoASenhaForInvalida() {
		assertFalse(service.senhaInvalida(FactoryMock.transacaoDtoSucesso()));
	}
	
	@Test
	public void deveCriticarQuandoOCartaoForInexistente() {
		service.cartaoInexistente(FactoryMock.transacaoDtoSucesso());
	}
	
	@Test
	public void deveCriticarQuandoOSaldoForInsuficiente() {
		service.saldoInsuficiente(FactoryMock.transacaoDtoSucesso());
	}
}
