package br.com.neuroconexao.neuroconexaobackend.services;

import br.com.neuroconexao.neuroconexaobackend.models.Vaga;
import br.com.neuroconexao.neuroconexaobackend.repositories.VagaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VagaService {
    private VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }


    public Vaga saveVaga(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public List<Vaga> getAllVagasDTO() {return vagaRepository.findAll();
    }

    public Vaga getVagaById( Long id) {
        return vagaRepository.findById(id).orElse(null);
    }
    public Vaga updateVaga(Long id, Vaga vagaAtualizada) {
        Vaga vagaExistente = vagaRepository.findById(id).orElse(null);
        if (vagaExistente != null) {
           vagaExistente.setTituloVaga(vagaAtualizada.getTituloVaga());
           vagaExistente.setDescricao(vagaAtualizada.getDescricao());
            return vagaRepository.save(vagaExistente);
        } else {
            throw new RuntimeException("Vaga com o ID" + id + "não encontrada.");
        }
    }

    public void deleteVaga(Long id) {
    }
}


