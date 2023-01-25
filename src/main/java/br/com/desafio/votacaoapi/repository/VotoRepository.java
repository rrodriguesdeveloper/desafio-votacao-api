package br.com.desafio.votacaoapi.repository;

import br.com.desafio.votacaoapi.domain.Voto;
import br.com.desafio.votacaoapi.domain.pk.VotoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, VotoPK> {
}
