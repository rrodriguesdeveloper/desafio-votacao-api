package br.com.desafio.votacaoapi.service.impl;

import br.com.desafio.votacaoapi.service.KafkaProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;

import static br.com.desafio.votacaoapi.builder.ResultadoDTOBuilder.umResultadoDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class KafkaProducerServiceImplTests {


    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Mock
    private KafkaTemplate kafkaTemplate;

    @Mock
    private ListenableFuture ongoingStubbing;

    @BeforeEach
    public void setUp() {
        kafkaTemplate = mock(KafkaTemplate.class);
        ongoingStubbing = mock(ListenableFuture.class);
        kafkaProducerService = new KafkaProducerImpl(kafkaTemplate);
    }

    @Test
    @DisplayName("deve escrever mensagem")
    public void deveEscreverMensagem() {
        Mockito.when(kafkaTemplate.send(any(String.class), any(String.class))).thenReturn(ongoingStubbing);

        kafkaProducerService.writeMessage(umResultadoDTO().toString());
    }

}
