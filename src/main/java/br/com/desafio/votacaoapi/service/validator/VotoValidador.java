package br.com.desafio.votacaoapi.service.validator;

import br.com.desafio.votacaoapi.domain.Voto;
import org.springframework.stereotype.Service;

@Service
public interface VotoValidador {
    void validar(Voto voto);
}
