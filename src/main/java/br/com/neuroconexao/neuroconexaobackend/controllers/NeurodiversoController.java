package br.com.neuroconexao.neuroconexaobackend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.neuroconexao.neuroconexaobackend.models.Neurodiverso;
import br.com.neuroconexao.neuroconexaobackend.services.NeurodiversoService;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/neurodiversos")
public class NeurodiversoController {

    @Autowired
    private NeurodiversoService ns;

    @PostMapping("/save")
    public Neurodiverso createNeurodiverso(@RequestBody @Valid Neurodiverso neurodiverso) {
        return ns.saveNeurodiverso(neurodiverso);
    }

    @GetMapping("/all")
    public List<Neurodiverso> getAllNeurodiversos() {
        return ns.getAllNeurodiversos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Neurodiverso> getNeurodiverso(@PathVariable Long id) {
        Neurodiverso neurodiverso = ns.getNeurodiversoById(id);
        return ResponseEntity.ok(neurodiverso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Neurodiverso> updateNeurodiverso(@PathVariable Long id,
            @Valid @RequestBody Neurodiverso updatedNeurodiverso) {
        Neurodiverso neurodiverso = ns.getNeurodiversoById(id);

        neurodiverso.setNeurodiversidade(updatedNeurodiverso.getNeurodiversidade());
        neurodiverso.setNome(updatedNeurodiverso.getNome());
        neurodiverso.setCpf(updatedNeurodiverso.getCpf());
        neurodiverso.setEmail(updatedNeurodiverso.getEmail());
        neurodiverso.setSenha(updatedNeurodiverso.getSenha());
        neurodiverso.setTelefone(updatedNeurodiverso.getTelefone());
        neurodiverso.setDataNascimento(updatedNeurodiverso.getDataNascimento());

        ns.updateNeurodiverso(id, updatedNeurodiverso);
        return ResponseEntity.ok(neurodiverso);
    }

    @DeleteMapping("/{id}")
    public void deleteNeurodiverso(@PathVariable Long id) {
        ns.deleteNeurodiverso(id);
    }
}
