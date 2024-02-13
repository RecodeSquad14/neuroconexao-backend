package br.com.neuroconexao.neuroconexaobackend.repositories;

import br.com.neuroconexao.neuroconexaobackend.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository <Vaga, Long> {}
