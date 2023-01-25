package br.com.desafio.votacaoapi.builder.voto;

import br.com.desafio.votacaoapi.domain.Voto;

import static br.com.desafio.votacaoapi.util.Constantes.SIM;

public class VotoBuilder {

    public static Voto umVoto() {
        return Voto.builder()
                .cpf("10338927425")
                .idPauta(1L)
                .voto(SIM)
                .build();
    }

    public static Voto umVoto(String voto) {
        return Voto.builder()
                .cpf("10338927425")
                .idPauta(1L)
                .voto(voto)
                .build();
    }
}
