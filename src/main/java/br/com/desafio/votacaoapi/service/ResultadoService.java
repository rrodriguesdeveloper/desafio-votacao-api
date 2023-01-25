package br.com.desafio.votacaoapi.service;

import br.com.desafio.votacaoapi.domain.dto.ResultadoDTO;
import org.springframework.stereotype.Service;

/**
 * Classe de interface de regra de negócios
 */
@Service
public interface ResultadoService {

    /**
     * Método responsável por obter um resultado
     * @param id
     * @return ResultadoDTO
     */
    ResultadoDTO obterResultado(Long id);

}
