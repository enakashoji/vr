package br.com.nk.vr.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.nk.vr.repository.CartaoRepository;
import br.com.nk.vr.service.TransacaoService;
import br.com.nk.vr.service.utils.FactoryMock;

@SpringBootTest
@AutoConfigureMockMvc
public class TransacaoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransacaoService service;

	@MockBean
	private CartaoRepository cartaoRepository;

	@Test
	public void deveRetornarSucessoQuandoRegistrarATransacao() throws Exception {

		when(service.senhaInvalida(FactoryMock.transacaoDtoSucesso())).thenReturn(false);
		when(service.cartaoInexistente(FactoryMock.transacaoDtoSucesso())).thenReturn(false);
		when(service.saldoInsuficiente(FactoryMock.transacaoDtoSucesso())).thenReturn(false);
		when(service.executaTransacao(FactoryMock.transacaoDtoSucesso())).thenReturn(FactoryMock.transacaoDtoSucesso());
		when(cartaoRepository.save(FactoryMock.criarCartaoSucesso())).thenReturn(FactoryMock.criarCartaoSucesso());

		RequestBuilder builder = MockMvcRequestBuilders.post("/transacoes", FactoryMock.transacaoDtoSucesso());

		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();

	}

	@Test
	public void deveValidarOSaldo() throws Exception {
		when(service.saldoInsuficiente(FactoryMock.transacaoDtoSucesso())).thenReturn(true);
		RequestBuilder builder = MockMvcRequestBuilders.post("/transacoes", FactoryMock.transacaoDtoSucesso());

		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andReturn();
	}
	
	@Test
	public void deveValidarASenha() throws Exception {
		when(service.senhaInvalida(FactoryMock.transacaoDtoSucesso())).thenReturn(true);
		RequestBuilder builder = MockMvcRequestBuilders.post("/transacoes", FactoryMock.transacaoDtoSucesso());

		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andReturn();
	}
	
	@Test
	public void deveValidarOCartao() throws Exception {
		when(service.cartaoInexistente(FactoryMock.transacaoDtoSucesso())).thenReturn(true);
		RequestBuilder builder = MockMvcRequestBuilders.post("/transacoes", FactoryMock.transacaoDtoSucesso());

		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andReturn();
	}
}
