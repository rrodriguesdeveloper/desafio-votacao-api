package br.com.desafio.votacaoapi.schedule;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.service.KafkaProducerService;
import br.com.desafio.votacaoapi.service.PautaService;
import br.com.desafio.votacaoapi.service.ResultadoService;
import br.com.desafio.votacaoapi.domain.dto.ResultadoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static br.com.desafio.votacaoapi.util.Constantes.FECHADA;
import static br.com.desafio.votacaoapi.util.Util.toJson;

@Component
@EnableScheduling
public class PautaSchedule {

    private static final Logger logger = LoggerFactory.getLogger(PautaSchedule.class);

    private final PautaService pautaService;
    private final ResultadoService resultadoService;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public PautaSchedule(PautaService pautaService,
                         ResultadoService resultadoService,
                         KafkaProducerService kafkaProducerService) {
        this.pautaService = pautaService;
        this.resultadoService = resultadoService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(fixedDelay = 1000)
    public void fecharPautaCasoVerdadeiro() {
        pautaService.consultarPautasAbertas().stream()
                .filter(Pauta::estahFechadaIhNaoFoiEnviada).forEach(pauta -> {
                    ResultadoDTO resultadoDTO = resultadoService.obterResultado(pauta.getId());
                    atulizarResultado(resultadoDTO);
                    logger.info("Enviando resultado :" + resultadoDTO);
                    kafkaProducerService.writeMessage(toJson(resultadoDTO));

                    logger.info("salvando pauta fechada :" + pauta);
                    sinalizarEnvioPauta(pauta);
                    pautaService.atualizarPauta(pauta);
                });
    }

    private void atulizarResultado(ResultadoDTO resultadoDTO) {
        resultadoDTO.setStatus(FECHADA);
    }

    private void sinalizarEnvioPauta(Pauta pauta) {
        pauta.setEnviadoKafka(true);
    }
}
