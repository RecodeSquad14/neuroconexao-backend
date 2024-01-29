package br.com.neuroconexao.neuroconexaobackend.controllers;


import br.com.neuroconexao.neuroconexaobackend.exception.ConfirmaSenhaException;
import br.com.neuroconexao.neuroconexaobackend.exception.ProfissionalNotFoundException;
import br.com.neuroconexao.neuroconexaobackend.models.Profissional;
import br.com.neuroconexao.neuroconexaobackend.services.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/profissionais")
@Validated
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProfissional(@Valid @RequestBody Profissional profissional) {
        try {
            profissionalService.confirmaSenha(profissional.getSenha(), profissional.getConfirmarSenha());
            profissionalService.saveProfissional(profissional);
            return ResponseEntity.ok("Profissional cadastrado");

        } catch (ConfirmaSenhaException e) {
            return ResponseEntity.status(400).body("Senha não confere com confirmação de senha");

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

        if (profissional != null) {
            return ResponseEntity.ok(profissional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> updateProfissional(@PathVariable Long id, @Valid @RequestBody Profissional profissional) {
        try {
            profissionalService.updateProfissional(id, profissional);
            return ResponseEntity.ok("Profissional atualizado com sucesso");
        } catch (ProfissionalNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar profissional");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfissional(@PathVariable @Valid Long id) {
        profissionalService.deleteProfissional(id);
        return ResponseEntity.ok("Excluido com sucesso");
    }
}


