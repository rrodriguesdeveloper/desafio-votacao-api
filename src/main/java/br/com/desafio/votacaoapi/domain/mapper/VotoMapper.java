package br.com.desafio.votacaoapi.domain.mapper;

import br.com.desafio.votacaoapi.domain.Voto;
import br.com.desafio.votacaoapi.domain.dto.VotoDTO;

public class VotoMapper {
    public static Voto toEntity(VotoDTO votoDTO) {
        return Voto.builder()
                .cpf(votoDTO.getCpf())
                .idPauta(votoDTO.getIdPauta())
                .idCooperado(votoDTO.getIdCooperado())
                .voto(votoDTO.getVoto())
                .build();
    }

    public static VotoDTO toDto(Voto voto) {
        return VotoDTO.builder()
                .cpf(voto.getCpf())
                .idPauta(voto.getIdPauta())
                .idCooperado(voto.getIdCooperado())
                .voto(voto.getVoto())
                .build();
    }
}
