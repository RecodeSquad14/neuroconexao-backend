package br.com.neuroconexao.neuroconexaobackend.services;

import java.util.List;

import br.com.neuroconexao.neuroconexaobackend.models.Empresa;


public interface EmpresaService {
	List<Empresa> getAllEmpresas();
	
	Empresa getEmpresaById(Long id);
	
	Empresa saveEmpresa(Empresa empresa);
	
	Empresa updateEmpresa(Long id, Empresa empresaAtt);
	
	void deleteEmpresa(Long id);
}
