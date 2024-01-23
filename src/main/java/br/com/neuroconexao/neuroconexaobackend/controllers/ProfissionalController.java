package br.com.neuroconexao.neuroconexaobackend.controllers;


import br.com.neuroconexao.neuroconexaobackend.models.Profissional;
import br.com.neuroconexao.neuroconexaobackend.services.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/profissionais")
@Validated
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping()
    public ResponseEntity<String> saveProfissional(@Valid @RequestBody Profissional profissional) {
        try {
            profissionalService.saveProfissional(profissional);
            return ResponseEntity.ok("Profissional cadastrado");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving profissional");
        }
    }

    @GetMapping
    public ResponseEntity listProfissionais() {
        List<Profissional> profissionais = profissionalService.getAllProfissionais();
        return ResponseEntity.ok(profissionais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getById(@PathVariable Long id) {
        Profissional profissional = profissionalService.getProfissionalById(id);
        return ResponseEntity.ok(profissional);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> updateProfissional(@PathVariable Long id, @Valid @RequestBody Profissional profissional) {
        profissionalService.updateProfissional(id, profissional);
        return ResponseEntity.ok("Profissional atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfissional(@PathVariable @Valid Long id) {
        profissionalService.deleteProfissional(id);
        return ResponseEntity.ok("Excluido com sucesso");
    }
}


