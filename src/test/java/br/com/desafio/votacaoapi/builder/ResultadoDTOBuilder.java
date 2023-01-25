package br.com.desafio.votacaoapi.builder;

import br.com.desafio.votacaoapi.domain.dto.ResultadoDTO;

import static br.com.desafio.votacaoapi.util.Constantes.SIM;

public class ResultadoDTOBuilder {

    public static ResultadoDTO umResultadoDTO(){
        return ResultadoDTO.builder()
                .seqPauta(1L)
                .titulo("coxinha > all")
                .quantidadeSim(100)
                .quantidadeNao(1)
                .resultado(SIM)
                .status("FECHADA")
                .build();
    }
}
