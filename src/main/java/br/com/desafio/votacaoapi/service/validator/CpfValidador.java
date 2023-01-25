package br.com.desafio.votacaoapi.service.validator;

import org.springframework.stereotype.Service;

@Service
public interface CpfValidador {

    void validar(String cpf);
}
