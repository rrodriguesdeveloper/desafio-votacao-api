package br.com.desafio.votacaoapi.service.impl;

import br.com.desafio.votacaoapi.domain.Voto;
import br.com.desafio.votacaoapi.repository.VotoRepository;
import br.com.desafio.votacaoapi.service.VotoService;
import br.com.desafio.votacaoapi.service.validator.PautaValidador;
import br.com.desafio.votacaoapi.service.validator.VotoValidador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe implementadora de regras de negócio
 */
@Component
public class VotoServiceImpl implements VotoService {

    private static final Logger logger = LoggerFactory.getLogger(VotoServiceImpl.class);

    private final VotoRepository votoRepository;
    private final VotoValidador votoValidador;
    private final PautaValidador pautaValidador;

    @Autowired
    public VotoServiceImpl(VotoRepository votoRepository,
                           VotoValidador votoValidador,
                           PautaValidador pautaValidador) {
        this.votoRepository = votoRepository;
        this.votoValidador = votoValidador;
        this.pautaValidador = pautaValidador;
    }

    /**
     * Méotodo responsável por validar e cadastrar um voto
     * @param voto
     * @return Voto
     */
    @Override
    public Voto cadastrar(Voto voto) {
        votoValidador.validar(voto);
        pautaValidador.validar(voto.getIdPauta());
        logger.info("cadastrando novo voto: " + voto);
        return votoRepository.save(voto);
    }

}

