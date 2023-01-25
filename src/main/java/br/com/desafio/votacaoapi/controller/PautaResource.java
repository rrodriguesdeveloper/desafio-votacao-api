package br.com.desafio.votacaoapi.controller;

import br.com.desafio.votacaoapi.domain.Pauta;
import br.com.desafio.votacaoapi.service.PautaService;
import br.com.desafio.votacaoapi.domain.dto.PautaDTO;
import br.com.desafio.votacaoapi.domain.dto.SessaoDTO;
import br.com.desafio.votacaoapi.domain.mapper.PautaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.desafio.votacaoapi.domain.mapper.PautaMapper.toDto;

@RestController
@RequestMapping("/pautas")
public class PautaResource {

    private final PautaService pautaService;

    @Autowired
    public PautaResource(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping(headers = "Api-Version=1")
    public ResponseEntity<Object> cadastrar(@RequestBody PautaDTO pautaDTO) {
        Pauta pautaCadastrada = pautaService.cadastrar(PautaMapper.toEntity(pautaDTO));
        return new ResponseEntity<>(toDto(pautaCadastrada), HttpStatus.CREATED);
    }

    @PostMapping(value = "/abrir", headers = "Api-Version=1")
    public ResponseEntity<Object> abrirVotacao(@RequestBody SessaoDTO sessaoDTO) {
        Pauta pautaAberta = pautaService.abrirVotacao(sessaoDTO);
        return new ResponseEntity<>(toDto(pautaAberta), HttpStatus.ACCEPTED);
    }
}

