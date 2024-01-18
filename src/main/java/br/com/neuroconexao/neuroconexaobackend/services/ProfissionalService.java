package br.com.neuroconexao.neuroconexaobackend.services;

import br.com.neuroconexao.neuroconexaobackend.models.Profissional;

import java.util.List;

public interface ProfissionalService {

    List<Profissional> getAllProfissionais();

    Profissional getProfissionalById(Long id);

    Profissional saveProfissional(Profissional profissional);

    Profissional updateProfissional(Long id, Profissional profissionalAtualizada);

    void deleteProfissional(Long id);
}

