package br.com.desafio.votacaoapi.builder.voto;

import br.com.desafio.votacaoapi.domain.dto.VotoDTO;

import static br.com.desafio.votacaoapi.util.Constantes.SIM;

public class VotoDTOBuilder {

    public static VotoDTO umVotoDTO() {
        return VotoDTO.builder()
                .cpf("10338927425")
                .idCooperado(1L)
                .idPauta(1L)
                .voto(SIM)
                .build();
    }

    public static VotoDTO umVotoDTO(String voto) {
        return VotoDTO.builder()
                .cpf("10338927425")
                .idCooperado(1L)
                .idPauta(1L)
                .voto(voto)
                .build();
    }
}
