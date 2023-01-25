package br.com.desafio.votacaoapi.service.impl;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.repository.PautaRepository;
import br.com.desafio.votacaoapi.service.PautaService;
import br.com.desafio.votacaoapi.domain.dto.SessaoDTO;
import br.com.desafio.votacaoapi.exception.PautaNaoEncontradaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.desafio.votacaoapi.util.Constantes.ABERTA;
import static br.com.desafio.votacaoapi.util.Constantes.PAUTA_NAO_ENCONTRADA_EXCEPTION;

/**
 * Classe implementadora de regras de negócio
 */
@Component
public class PautaServiceImpl implements PautaService {

    private static final Logger logger = LoggerFactory.getLogger(PautaServiceImpl.class);

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaServiceImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    /**
     * Método responsável por salvar pautas
     * @param pauta
     * @return Pauta
     */
    @Override
    public Pauta cadastrar(Pauta pauta) {
        pauta.obterStatusFechadaCasoNulo(pauta);

        logger.info("salvando pauta: " + pauta);
        return pautaRepository.save(pauta);
    }

    /**
     * Método responspavel por abrir uma votação
     * @param sessaoDTO
     * @return Pauta
     */
    @Override
    public Pauta abrirVotacao(SessaoDTO sessaoDTO) {
        logger.info("abrindo nova Sessao: " + sessaoDTO);

        Pauta pauta = buscarPorId(sessaoDTO.getIdPauta());
        pauta.abrirVotacao(sessaoDTO);

        logger.info("salvando pauta: " + pauta);
        return pautaRepository.save(pauta);
    }

    /**
     * Método responsável por buscar uma pauta por ID
     * @param id
     * @return Pauta
     */
    @Override
    public Pauta buscarPorId(Long id) {
        logger.info("abrindo nova Pauta por id: " + id);

        return pautaRepository.findById(id).orElseThrow(() -> {
            throw new PautaNaoEncontradaException(PAUTA_NAO_ENCONTRADA_EXCEPTION);
        });
    }

    /**
     * Método responsável por consultar as pautas abertas
     * @return List<Pauta>
     */
    @Override
    public List<Pauta> consultarPautasAbertas() {
        logger.info("Consultando paltas com status aberto");

        return pautaRepository.findAllByStatus(ABERTA);
    }

    /**
     * Método responsável por atualizar uma pauta
     * @param pauta
     * @return Pauta
     */
    @Override
    public Pauta atualizarPauta(Pauta pauta) {
        logger.info("atualizando pauta: " + pauta);

        return this.pautaRepository.save(pauta);
    }

}
