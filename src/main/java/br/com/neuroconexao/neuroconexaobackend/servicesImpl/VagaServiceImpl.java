package br.com.neuroconexao.neuroconexaobackend.servicesImpl;

import br.com.neuroconexao.neuroconexaobackend.models.Vaga;
import br.com.neuroconexao.neuroconexaobackend.repositories.VagaRepository;
import br.com.neuroconexao.neuroconexaobackend.services.EmpresaService;
import br.com.neuroconexao.neuroconexaobackend.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VagaServiceImpl implements VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Override
    public List<Vaga> getAllVagas() {
        return vagaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vaga getVagaById(Long id) {
        return vagaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Vaga saveVaga(Vaga vaga) {
        empresaService.getEmpresaById(vaga.getEmpresa().getId());
        return vagaRepository.save(vaga);
    }

    @Override
    public Vaga updateVaga(Long id, Vaga vagaAtt) {
        Vaga vagaExistente = vagaRepository.findById(id).orElse(null);
        if (vagaExistente != null) {
            vagaExistente.setDescricao(vagaAtt.getDescricao());
            vagaExistente.setTituloVaga(vagaAtt.getTituloVaga());
            return vagaRepository.save(vagaExistente);
        } else {
            throw new RuntimeException("Vaga com Id " + id + " não encontrada");
        }
    }

    @Override
    public void deleteVaga(Long id) {
        vagaRepository.deleteById(id);

    }

}
