package br.com.desafio.votacaoapi.service.impl;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.domain.Voto;
import br.com.desafio.votacaoapi.service.PautaService;
import br.com.desafio.votacaoapi.service.ResultadoService;
import br.com.desafio.votacaoapi.domain.dto.ResultadoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.desafio.votacaoapi.util.Constantes.*;

/**
 * Classe implementadora de regras de negócio
 */
@Component
public class ResultadoServiceImpl implements ResultadoService {

    private static final Logger logger = LoggerFactory.getLogger(ResultadoServiceImpl.class);

    private final PautaService pautaService;

    @Autowired
    public ResultadoServiceImpl(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    /**
     * Método responsável por obter o resultado por ID
     * @param id
     * @return ResultadoDTO
     */
    @Override
    public ResultadoDTO obterResultado(Long id) {
        logger.info("obtendo resultado de pauta numero: " + id);

        Pauta pauta = pautaService.buscarPorId(id);

        return construirResultado(pauta);
    }

    /**
     * Método responsável por montar o resultado de acordo com o tipo:
     * -Sim
     * -Nao
     * @param pauta
     * @return ResultadoDTO
     */
    private ResultadoDTO construirResultado(Pauta pauta) {
        Integer quantidadeSim = obterQuantidadePorOpcao(pauta.getVotos(), SIM);
        Integer quantidadeNao = obterQuantidadePorOpcao(pauta.getVotos(), NAO);

        return ResultadoDTO.builder()
                .seqPauta(pauta.getId())
                .titulo(pauta.getTitulo())
                .quantidadeNao(quantidadeNao)
                .quantidadeSim(quantidadeSim)
                .status(pauta.getStatus())
                .resultado(calcularVotos(quantidadeSim, quantidadeNao))
                .build();
    }

    /**
     * Método responsável por calcular os votos de acordo com os tipos:
     * -Empate
     * -Nao
     * -Sim
     * @param quantidadeSim
     * @param quantidadeNao
     * @return String
     */
    private String calcularVotos(Integer quantidadeSim, Integer quantidadeNao) {
        if (quantidadeNao.equals(quantidadeSim)) {
            return EMPATE;
        } else if (quantidadeNao > quantidadeSim) {
            return NAO;
        } else {
            return SIM;
        }
    }

    /**
     * Método responsável por obter a quantidade de votos
     * @param votos
     * @param opcao
     * @return Integer
     */
    private Integer obterQuantidadePorOpcao(Set<Voto> votos, String opcao) {
        List<Voto> votosFiltrados = votos
                .stream()
                .filter(voto -> opcao.equals(voto.getVoto())).collect(Collectors.toList());

        return votosFiltrados.size();
    }

}
