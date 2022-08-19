package br.com.nk.vr.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.nk.vr.repository.CartaoRepository;
import br.com.nk.vr.service.utils.FactoryMock;

@SpringBootTest
public class TransacaoServiceTest {
	
	@MockBean
	private CartaoService cartaoSerive;
	
	@Mock
	private CartaoRepository repository;
	
	@Autowired
	private TransacaoService service;
	
	@Test
	public void deveCriticarQuandoASenhaForInvalida() {
		when(cartaoSerive.cartaoExiste(FactoryMock.transacaoDtoSucesso().getNumeroCartao())).thenReturn(true);
		when(repository.findById(FactoryMock.transacaoDtoSucesso().getNumeroCartao())).thenReturn(FactoryMock.optionalCartaoSucesso());
		assertFalse(service.senhaInvalida(FactoryMock.transacaoDtoSucesso()));
	}
	
	@Test
	public void deveCriticarQuandoOCartaoForInexistente() {
		when(cartaoSerive.cartaoExiste(FactoryMock.transacaoDtoSucesso().getNumeroCartao())).thenReturn(false);
		service.cartaoInexistente(FactoryMock.transacaoDtoSucesso());
	}
	
	@Test
	public void deveCriticarQuandoOSaldoForInsuficiente() {
		when(cartaoSerive.consultarSaldo(FactoryMock.criarCartaoDtoSucesso().getNumeroCartao())).thenReturn(BigDecimal.ZERO);
		service.saldoInsuficiente(FactoryMock.transacaoDtoSucesso());
	}
}
