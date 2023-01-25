package br.com.desafio.votacaoapi.service;

import org.springframework.stereotype.Service;

/**
 * Classe de interface de regra de negócios
 */
@Service
public interface KafkaProducerService {

    /**
     * Método responsável por enviar uma mensagem
     * @param message
     */
    void writeMessage(String message);

}
