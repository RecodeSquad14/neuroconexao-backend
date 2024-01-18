package br.com.neuroconexao.neuroconexaobackend.repositories;

import br.com.neuroconexao.neuroconexaobackend.models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}

