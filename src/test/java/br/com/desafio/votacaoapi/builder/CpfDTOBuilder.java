package br.com.desafio.votacaoapi.builder;

import br.com.desafio.votacaoapi.domain.dto.CpfDTO;

import static br.com.desafio.votacaoapi.util.Constantes.ABLE_TO_VOTE;
import static br.com.desafio.votacaoapi.util.Constantes.UNABLE_TO_VOTE;

public class CpfDTOBuilder {

    public static CpfDTO umCpfDTOInvalido(){
        return CpfDTO.builder()
                .status(UNABLE_TO_VOTE)
                .build();
    }

    public static CpfDTO umCpfDTOValido(){
        return CpfDTO.builder()
                .status(ABLE_TO_VOTE)
                .build();
    }
}
