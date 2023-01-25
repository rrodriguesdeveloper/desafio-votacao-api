package br.com.desafio.votacaoapi.repository;

import br.com.desafio.votacaoapi.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
    List<Pauta> findAllByStatus(String aberta);

}
