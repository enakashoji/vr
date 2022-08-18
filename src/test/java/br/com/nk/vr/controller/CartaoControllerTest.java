package br.com.nk.vr.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.nk.vr.service.CartaoService;
import br.com.nk.vr.service.utils.FactoryMock;
import io.restassured.http.ContentType;

@WebMvcTest
public class CartaoControllerTest {

	@MockBean
	private CartaoService service;

	private CartaoController cartaoController;

	public CartaoControllerTest(CartaoController cartaoController) {
		this.cartaoController = cartaoController;
	}

	@BeforeEach
	public void setup() {
		standaloneSetup(this.cartaoController);
	}

	@Test
	public void deveRetornarSucessoQuandoCriarCartao() {
		when(service.criarCartao(FactoryMock.criarCartaoDtoSucesso())).thenReturn(FactoryMock.criarCartaoDtoSucesso());
		given().accept(ContentType.JSON).when()
				.post("/cartoes", FactoryMock.criarCartaoDtoSucesso()).then()
				.statusCode(HttpStatus.OK.value());
	}

//	@Test
//	public void deveRetornarCartaoJaExisteQuandoONumeroForIgual() {
//		when(service.criarCartao(FactoryMock.criarCartaoDtoSucesso())).thenReturn(null);
//
//		given().body(FactoryMock.criarCartaoDtoSucesso()).accept(ContentType.JSON).when()
//				.post("/cartoes", FactoryMock.criarCartaoDtoSucesso().getNumeroCartao()).then()
//				.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
//
//	}

}
