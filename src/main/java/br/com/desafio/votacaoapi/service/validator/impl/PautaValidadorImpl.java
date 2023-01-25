package br.com.desafio.votacaoapi.service.validator.impl;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.service.PautaService;
import br.com.desafio.votacaoapi.service.validator.PautaValidador;
import br.com.desafio.votacaoapi.exception.SessaoFechadaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.desafio.votacaoapi.util.Constantes.SESSAO_FECHADA_EXCEPTION;

@Component
public class PautaValidadorImpl implements PautaValidador {


    private static final Logger logger = LoggerFactory.getLogger(PautaValidadorImpl.class);

    private final PautaService pautaService;

    @Autowired
    public PautaValidadorImpl(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Override
    public void validar(Long idPauta) {
        logger.info("validando pauta nº: "+ idPauta);
        Pauta pauta = pautaService.buscarPorId(idPauta);
        if (pauta.estahFechada()) {
            throw new SessaoFechadaException(SESSAO_FECHADA_EXCEPTION);
        }
    }

}
