package br.com.neuroconexao.neuroconexaobackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neuroconexao.neuroconexaobackend.models.Neurodiverso;

@Repository
public interface NeurodiversoRepository extends JpaRepository<Neurodiverso, Long> {
    // You can add custom query methods if needed
}