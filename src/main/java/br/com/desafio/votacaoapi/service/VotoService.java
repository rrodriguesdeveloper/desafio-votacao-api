package br.com.desafio.votacaoapi.service;

import br.com.desafio.votacaoapi.domain.Voto;
import org.springframework.stereotype.Service;

/**
 * Classe de interface de regra de negócios
 */
@Service
public interface VotoService {

    /**
     * Método responsável por cadastrar um voto
     * @param voto
     * @return Voto
     */
    Voto cadastrar(Voto voto);

}
