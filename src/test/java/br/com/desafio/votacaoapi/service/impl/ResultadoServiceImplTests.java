package br.com.desafio.votacaoapi.service.impl;

import br.com.desafio.votacaoapi.service.PautaService;
import br.com.desafio.votacaoapi.service.ResultadoService;
import br.com.desafio.votacaoapi.domain.dto.ResultadoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static br.com.desafio.votacaoapi.builder.pauta.PautaBuilder.*;
import static br.com.desafio.votacaoapi.util.Constantes.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class ResultadoServiceImplTests {

    private ResultadoService resultadoService;

    private PautaService pautaService;

    @BeforeEach
    public void setUp() {
        pautaService = mock(PautaServiceImpl.class);
        resultadoService = new ResultadoServiceImpl(pautaService);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Sim")
    public void resultadoDaPautaDeveSerSim() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaComMaisVotosSim());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), SIM);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Não")
    public void resultadoDaPautaDeveSerNao() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaComMaisVotosNao());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), NAO);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Empate")
    public void resultadoDaPautaDeveSerEmpate() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaEmpatada());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), EMPATE);
    }
}
