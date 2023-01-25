package br.com.desafio.votacaoapi.builder.pauta;

import br.com.desafio.votacaoapi.domain.dto.PautaDTO;

public class PautaDTOBuilder {

    public static PautaDTO umaPautaDTO(){
        return PautaDTO.builder()
                .id(1L)
                .titulo("coxinha > all")
                .build();
    }
}
