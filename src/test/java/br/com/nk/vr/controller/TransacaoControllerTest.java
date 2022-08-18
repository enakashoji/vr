package br.com.nk.vr.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.nk.vr.service.TransacaoService;
import br.com.nk.vr.service.utils.FactoryMock;
import io.restassured.http.ContentType;

@SpringBootTest
public class TransacaoControllerTest {

	@MockBean
	private TransacaoService service;

	@Autowired
	private TransacaoController transacaoController;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.transacaoController);
	}
	
	@Test
	public void deveRetornarSucessoQuandoRegistrarATransacao() {
		when(service.senhaInvalida(FactoryMock.transacaoDtoSucesso())).thenReturn(true);
		when(service.cartaoInexistente(FactoryMock.transacaoDtoSucesso())).thenReturn(true);
		when(service.saldoInsuficiente(FactoryMock.transacaoDtoSucesso())).thenReturn(true);
		when(service.executaTransacao(FactoryMock.transacaoDtoSucesso())).thenReturn(FactoryMock.transacaoDtoSucesso());
		given().accept(ContentType.JSON).when()
				.post("/transacoes", FactoryMock.transacaoDtoSucesso()).then()
				.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void deveRetornarQuandoOSaldoForInsuficiente() {
		when(service.senhaInvalida(FactoryMock.transacaoDtoSucesso())).thenReturn(true);
		given()
		.accept(ContentType.JSON)
		.when()
			.post("/transacoes", FactoryMock.transacaoDtoSucesso())
		.then()
			.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
	}
}


