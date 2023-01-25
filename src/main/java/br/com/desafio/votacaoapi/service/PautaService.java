package br.com.desafio.votacaoapi.service;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.domain.dto.SessaoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de interface de regra de negócios
 */
@Service
public interface PautaService {

    /**
     * Método responsável por cadastar uma pauta
     * @param toEntity
     * @return Pauta
     */
    Pauta cadastrar(Pauta toEntity);

    /**
     * Método responsável por abrir uma votação
     * @param sessaoDTO
     * @return Pauta
     */
    Pauta abrirVotacao(SessaoDTO sessaoDTO);

    /**
     * Método responsável por buscar por ID
     * @param id
     * @return Pauta
     */
    Pauta buscarPorId(Long id);

    /**
     * Método responsável por consultar pautas abertas
     * @return List<Pauta>
     */
    List<Pauta> consultarPautasAbertas();

    /**
     * Método responsável por atualizar uma pauta
     * @param pauta
     * @return Pauta
     */
    Pauta atualizarPauta(Pauta pauta);
}
