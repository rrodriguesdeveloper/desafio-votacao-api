package br.com.desafio.votacaoapi.controller;

import br.com.desafio.votacaoapi.domain.Voto;
import br.com.desafio.votacaoapi.service.VotoService;
import br.com.desafio.votacaoapi.domain.dto.VotoDTO;
import br.com.desafio.votacaoapi.domain.mapper.VotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votos")
public class VotoController {

    private final VotoService votoService;

    @Autowired
    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping(headers = "Api-Version=1")
    public ResponseEntity<Object> cadastrar(@RequestBody VotoDTO votoDTO) {
        Voto votoCadastrado = votoService.cadastrar(VotoMapper.toEntity(votoDTO));
        return new ResponseEntity<>(VotoMapper.toDto(votoCadastrado), HttpStatus.CREATED);
    }
}
