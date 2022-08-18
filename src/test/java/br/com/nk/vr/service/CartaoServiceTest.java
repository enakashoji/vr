package br.com.nk.vr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.nk.vr.model.dto.CartaoDto;
import br.com.nk.vr.repository.CartaoRepository;
import br.com.nk.vr.service.impl.CartaoServiceImpl;
import br.com.nk.vr.service.utils.FactoryMock;

@SpringBootTest
public class CartaoServiceTest {

	@Mock
	private CartaoRepository repository;

	private CartaoService service;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		service = new CartaoServiceImpl(repository);
		when(repository.findById("12345")).thenReturn(Optional.of(FactoryMock.criarCartaoSucesso()));
		when(repository.save(FactoryMock.criarCartaoSucesso())).thenReturn(FactoryMock.criarCartaoSucesso());
	}

	@Test
	public void deveCriarCartaoNovo() {
		CartaoDto dto = service.criarCartao(FactoryMock.criarCartaoDtoSucesso());
		assertEquals(dto.getNumeroCartao(), FactoryMock.criarCartaoDtoSucesso().getNumeroCartao());
		assertEquals(dto.getSenha(), FactoryMock.criarCartaoDtoSucesso().getSenha());
	}

	@Test
	public void deveValidarSeOCartaoExiste() {
		assertTrue(service.cartaoExiste(FactoryMock.criarCartaoDtoSucesso().getNumeroCartao()));
	}

	@Test
	public void deveValidarASenha() {
		assertTrue(service.validaSenha(FactoryMock.criarCartaoDtoSucesso()));
	}

	@Test
	public void deveExibirOSaldo() {
		assertEquals(service.consultarSaldo(FactoryMock.criarCartaoDtoSucesso().getNumeroCartao()), new BigDecimal(500).setScale(2));
	}
	
	@Test
	public void deveAtualizarOSaldo() {
		
	}
}
