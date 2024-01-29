package br.com.neuroconexao.neuroconexaobackend.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.neuroconexao.neuroconexaobackend.models.Neurodiverso;
import br.com.neuroconexao.neuroconexaobackend.repositories.NeurodiversoRepository;
import br.com.neuroconexao.neuroconexaobackend.services.NeurodiversoService;

import java.util.List;
import java.util.Optional;

@Service
public class NeurodiversoServiceImpl implements NeurodiversoService {

    @Autowired
    private NeurodiversoRepository neurodiversoRepository;

    @Override
    public List<Neurodiverso> getAllNeurodiversos() {
        return neurodiversoRepository.findAll();
    }

    @Override
    public Neurodiverso getNeurodiversoById(Long id) {
        Optional<Neurodiverso> optionalNeurodiverso = neurodiversoRepository.findById(id);
        return optionalNeurodiverso.orElse(null);
    }

    @Override
    public Neurodiverso createNeurodiverso(@RequestBody Neurodiverso neurodiverso) {
        return neurodiversoRepository.save(neurodiverso);
    }

    @Override
    public Neurodiverso updateNeurodiverso(Long id, Neurodiverso neurodiverso) {
        Optional<Neurodiverso> optionalNeurodiverso = neurodiversoRepository.findById(id);
        if (optionalNeurodiverso.isPresent()) {
            Neurodiverso existingNeurodiverso = optionalNeurodiverso.get();
            existingNeurodiverso.setNeurodiversidade(neurodiverso.getNeurodiversidade());
            existingNeurodiverso.setNome(neurodiverso.getNome());
            existingNeurodiverso.setCpf(neurodiverso.getCpf());
            existingNeurodiverso.setEmail(neurodiverso.getEmail());
            existingNeurodiverso.setSenha(neurodiverso.getSenha());
            existingNeurodiverso.setTelefone(neurodiverso.getTelefone());
            existingNeurodiverso.setDataNascimento(neurodiverso.getDataNascimento());

            // Atualize outros campos conforme necessário
            return neurodiversoRepository.save(existingNeurodiverso);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteNeurodiverso(Long id) {
        Optional<Neurodiverso> optionalNeurodiverso = neurodiversoRepository.findById(id);
        if (optionalNeurodiverso.isPresent()) {
            neurodiversoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Neurodiverso saveNeurodiverso(Neurodiverso neurodiverso) {

        return neurodiversoRepository.save(neurodiverso);
    }
}
