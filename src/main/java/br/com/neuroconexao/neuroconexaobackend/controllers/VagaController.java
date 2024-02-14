package br.com.neuroconexao.neuroconexaobackend.controllers;

import br.com.neuroconexao.neuroconexaobackend.domain.VagaDTO;
import br.com.neuroconexao.neuroconexaobackend.models.Empresa;
import br.com.neuroconexao.neuroconexaobackend.models.Vaga;
import br.com.neuroconexao.neuroconexaobackend.services.VagaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/vagas")
public class VagaController {

    private VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveVaga(@RequestBody Vaga vaga) {
        vagaService.saveVaga(vaga);
        return ResponseEntity.ok("Vaga cadastrada");
    }

    @GetMapping
    public ResponseEntity listVagas() {
        List<Vaga> vagas = vagaService.getAllVagas();
        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> getById(@PathVariable Long id) {
        Vaga vaga = vagaService.getVagaById(id);
        return ResponseEntity.ok(vaga);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> updateVaga(@PathVariable Long id, @RequestBody Vaga vaga) {
        vagaService.updateVaga(id, vaga);
        return ResponseEntity.ok("Vaga atualizada com sucesso");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVaga(@PathVariable Long id) {
        vagaService.deleteVaga(id);
        return ResponseEntity.ok(" Vaga excluida com sucesso");
    }
}


