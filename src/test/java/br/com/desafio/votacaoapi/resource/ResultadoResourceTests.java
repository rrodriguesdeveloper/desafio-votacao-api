package br.com.desafio.votacaoapi.resource;

import br.com.desafio.votacaoapi.service.ResultadoService;
import br.com.desafio.votacaoapi.controller.ResultadoResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static br.com.desafio.votacaoapi.builder.ResultadoDTOBuilder.umResultadoDTO;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(controllers = ResultadoResource.class)
public class ResultadoResourceTests {

    @Autowired
    private ResultadoResource resultadoResource;

    @MockBean
    private ResultadoService resultadoService;

    @BeforeEach
    public void setUp() {
        standaloneSetup(this.resultadoResource);
    }

    @Test
    @DisplayName("deve obter resultado com sucesso")
    public void deveObterResultadoComSucesso() {
        Mockito.when(resultadoService.obterResultado(any(Long.class))).thenReturn(umResultadoDTO());

        given()
                .header("Api-Version", 1)
                .accept(JSON)
                .when()
                .get("/resultados/{id}", 1L)
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }
}
