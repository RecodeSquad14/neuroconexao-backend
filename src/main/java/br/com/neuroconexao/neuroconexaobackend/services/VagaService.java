package br.com.neuroconexao.neuroconexaobackend.services;

import br.com.neuroconexao.neuroconexaobackend.models.Vaga;

import java.util.List;

public interface VagaService {
    List<Vaga> getAllVagas();

    Vaga getVagaById(Long id);

    Vaga saveVaga(Vaga vaga);

    Vaga updateVaga(Long id, Vaga vagaAtt);

    void deleteVaga(Long id);

}
