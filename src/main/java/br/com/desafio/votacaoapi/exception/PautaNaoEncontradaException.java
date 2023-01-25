package br.com.desafio.votacaoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PautaNaoEncontradaException extends RuntimeException {

    public PautaNaoEncontradaException(String exception) {
        super(exception);
    }

}
