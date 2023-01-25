package br.com.desafio.votacaoapi.resource;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.service.PautaService;
import br.com.desafio.votacaoapi.controller.PautaResource;
import br.com.desafio.votacaoapi.domain.dto.SessaoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static br.com.desafio.votacaoapi.builder.SessaoDTOBuilder.umaSessaoComMinuto;
import static br.com.desafio.votacaoapi.builder.pauta.PautaBuilder.umaPautaAberta;
import static br.com.desafio.votacaoapi.builder.pauta.PautaBuilder.umaPautaFechada;
import static br.com.desafio.votacaoapi.builder.pauta.PautaDTOBuilder.umaPautaDTO;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(controllers = PautaResource.class)
public class PautaResourceTests {

    @Autowired
    private PautaResource pautaResource;

    @MockBean
    private PautaService pautaService;

    @BeforeEach
    public void setUp() {
        standaloneSetup(this.pautaResource);
    }

    @Test
    @DisplayName("deve cadastrar pauta com sucesso")
    public void deveCadastrarPautaComSucesso() {
        Mockito.when(this.pautaService.cadastrar(any(Pauta.class))).thenReturn(umaPautaFechada());

        given().contentType(JSON)
                .header("Api-Version", 1)
                .body(umaPautaDTO())
                .when()
                .post("/pautas", umaPautaDTO())
                .then().log().all()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("deve abrir uma sessao em uma pauta")
    public void deveAbrirUmaSessaoEmUmaPauta() {
        Mockito.when(this.pautaService.abrirVotacao(any(SessaoDTO.class))).thenReturn(umaPautaAberta());

        given().contentType(JSON)
                .header("Api-Version", 1)
                .body(umaSessaoComMinuto())
                .when()
                .post("/pautas/abrir", umaSessaoComMinuto())
                .then().log().all()
                .statusCode(HttpStatus.ACCEPTED.value());
    }

}
