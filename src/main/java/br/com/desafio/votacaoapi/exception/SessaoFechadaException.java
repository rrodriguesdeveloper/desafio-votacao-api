package br.com.desafio.votacaoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SessaoFechadaException extends RuntimeException {

    public SessaoFechadaException(String exception) {
        super(exception);
    }

}
