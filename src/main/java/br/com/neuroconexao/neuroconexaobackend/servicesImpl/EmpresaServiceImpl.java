package br.com.neuroconexao.neuroconexaobackend.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.neuroconexao.neuroconexaobackend.models.Empresa;
import br.com.neuroconexao.neuroconexaobackend.repositories.EmpresaRepository;
import br.com.neuroconexao.neuroconexaobackend.services.EmpresaService;

public class EmpresaServiceImpl implements EmpresaService{
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public List<Empresa> getAllEmpresas() {
		return empresaRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Empresa getEmpresaById(Long id) {
		return empresaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empresa saveEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public Empresa updateEmpresa(Long id, Empresa empresaAtt) {
		Empresa empresaExistente = empresaRepository.findById(id).orElse(null);
		if(empresaExistente != null) {
			empresaExistente.setNome(empresaAtt.getNome());
			empresaExistente.setCnpj(empresaAtt.getCnpj());
			empresaExistente.setEndereco(empresaAtt.getEndereco());
			empresaExistente.setEmail_corporativo(empresaAtt.getEmail_corporativo());
			empresaExistente.setSenha(empresaAtt.getSenha());
			return empresaRepository.save(empresaExistente);
		}else {
			throw new RuntimeException("Empresa com Id " + id + " não encontrada"); 
		}
		
	}

	@Override
	public void deleteEmpresa(Long id) {
		empresaRepository.deleteById(id);
		
	}
}
