package br.com.neuroconexao.neuroconexaobackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.neuroconexao.neuroconexaobackend.models.Empresa;

import br.com.neuroconexao.neuroconexaobackend.services.EmpresaService;
import jakarta.validation.Valid;

public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	// listar
	@GetMapping
	public ResponseEntity listEmpresas() {
		List<Empresa> empresas = empresaService.getAllEmpresas();
		return ResponseEntity.ok(empresas);
	}

	// Persistencia Criação
	@PostMapping()
	public ResponseEntity<String> saveEmpresa(@Valid @RequestBody Empresa empresa) {
		try {
			empresaService.saveEmpresa(empresa);
			return ResponseEntity.ok("Empresa cadastrada");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error saving empresa");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empresa> getById(@PathVariable Long id) {
		Empresa empresa = empresaService.getEmpresaById(id);
		return ResponseEntity.ok(empresa);
	}

	// Persistencia de Edição
	@PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> updateEmpresa(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
        empresaService.updateEmpresa(id, empresa);
        return ResponseEntity.ok("Empresa atualizada com sucesso");
    }

	// Excluir empresa
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable @Valid Long id) {
        empresaService.deleteEmpresa(id);
        return ResponseEntity.ok("Empresa excluida com sucesso");
    }
}
