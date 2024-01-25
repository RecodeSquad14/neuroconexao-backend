package br.com.neuroconexao.neuroconexaobackend.servicesImpl;

import br.com.neuroconexao.neuroconexaobackend.exception.ConfirmaSenhaException;
import br.com.neuroconexao.neuroconexaobackend.models.Profissional;
import br.com.neuroconexao.neuroconexaobackend.repositories.ProfissionalRepository;
import br.com.neuroconexao.neuroconexaobackend.services.ProfissionalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Override
    public List<Profissional> getAllProfissionais() {
        return profissionalRepository.findAll();
    }

    @Override
    @Transactional
    public Profissional getProfissionalById(Long id) {
        return profissionalRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Profissional saveProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @Transactional
    public void confirmaSenha(String senha, String confirmarSenha) {
        if (!senha.equals(confirmarSenha)) {
            throw new ConfirmaSenhaException("Senha não confere com confirmação de senha.");
        }

    }
    @Override
    public Profissional updateProfissional(Long id, Profissional profissionalAtualizado) {
        Profissional profissionalExistente = profissionalRepository.findById(id).orElse(null);
        if (profissionalExistente != null) {
            profissionalExistente.setAreaAtuacao(profissionalAtualizado.getArea_de_atuacao());
            profissionalExistente.setNome(profissionalAtualizado.getNome());
            profissionalExistente.setEmail(profissionalAtualizado.getEmail());
            profissionalExistente.setSenha(profissionalAtualizado.getSenha());

            return profissionalRepository.save(profissionalExistente);
        } else {
            throw new RuntimeException("Profissional com o ID" + id + "não encontrada.");
        }
    }
    @Override
    public void deleteProfissional(Long id) {
        profissionalRepository.deleteById(id);
    }
}
