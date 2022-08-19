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

import br.com.nk.vr.service.CartaoService;
import br.com.nk.vr.service.utils.FactoryMock;

@SpringBootTest
@AutoConfigureMockMvc
public class CartaoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CartaoService service;

	@Test
	public void deveRetornarSucessoQuandoCriarCartao() throws Exception {
		when(service.criarCartao(FactoryMock.criarCartaoDtoSucesso())).thenReturn(FactoryMock.criarCartaoDtoSucesso());
		
		RequestBuilder builder = MockMvcRequestBuilders.post("/cartoes", FactoryMock.criarCartaoDtoSucesso());

		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
	}

	@Test
	public void deveRetornarCartaoJaExisteQuandoONumeroForIgual() throws Exception {
		when(service.criarCartao(FactoryMock.criarCartaoDtoSucesso())).thenReturn(FactoryMock.criarCartaoDtoSucesso());

		RequestBuilder builder = MockMvcRequestBuilders.post("/cartoes", FactoryMock.criarCartaoDtoSucesso());

		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andReturn();

	}

}
