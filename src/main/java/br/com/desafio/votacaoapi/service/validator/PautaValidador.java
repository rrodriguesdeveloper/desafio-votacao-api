package br.com.desafio.votacaoapi.service.validator;

import org.springframework.stereotype.Service;

@Service
public interface PautaValidador {
    void validar(Long idPauta);
}
