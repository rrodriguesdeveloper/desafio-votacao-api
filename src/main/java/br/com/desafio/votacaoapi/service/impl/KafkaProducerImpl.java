package br.com.desafio.votacaoapi.service.impl;

import br.com.desafio.votacaoapi.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Classe implementadora de regras de negócio
 */
@Component
public class KafkaProducerImpl implements KafkaProducerService {

    public static final String TOPIC = "my_topic";

    public KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Método responsável por enviar uma mensagem para o tópico my_topic
     * @param message
     */
    @Override
    public void writeMessage(String message) {

        this.kafkaTemplate.send(TOPIC, message);
    }
}
