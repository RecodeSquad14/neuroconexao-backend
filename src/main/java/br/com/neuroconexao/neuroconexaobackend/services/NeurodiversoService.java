package br.com.neuroconexao.neuroconexaobackend.services;

import java.util.List;

import br.com.neuroconexao.neuroconexaobackend.models.Neurodiverso;



public interface NeurodiversoService {
    List<Neurodiverso> getAllNeurodiversos();
    Neurodiverso getNeurodiversoById(Long id);
    Neurodiverso createNeurodiverso(Neurodiverso neurodiverso);
    Neurodiverso updateNeurodiverso(Long id, Neurodiverso neurodiverso);
    boolean deleteNeurodiverso(Long id);
	Neurodiverso saveNeurodiverso(Neurodiverso neurodiverso);
}
