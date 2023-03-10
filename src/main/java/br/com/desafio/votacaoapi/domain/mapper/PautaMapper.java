package br.com.desafio.votacaoapi.domain.mapper;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.domain.dto.PautaDTO;

public class PautaMapper {
    public static Pauta toEntity(PautaDTO pautaDTO) {
        return Pauta.builder()
                .id(pautaDTO.getId())
                .status(pautaDTO.getStatus())
                .tempoLimite(pautaDTO.getTempoLimite())
                .titulo(pautaDTO.getTitulo())
                .build();
    }

    public static PautaDTO toDto(Pauta pauta) {
        return PautaDTO.builder()
                .id(pauta.getId())
                .status(pauta.getStatus())
                .tempoLimite(pauta.getTempoLimite())
                .titulo(pauta.getTitulo())
                .build();
    }
}
