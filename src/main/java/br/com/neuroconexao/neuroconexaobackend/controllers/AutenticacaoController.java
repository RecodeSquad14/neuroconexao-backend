package br.com.neuroconexao.neuroconexaobackend.controllers;

import br.com.neuroconexao.neuroconexaobackend.models.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequestMapping("/api/v1")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;

    public AutenticacaoController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> autenticar(@RequestBody @Valid Usuario usuario, HttpServletRequest request) {
        log.info("Processo de autenticação pelo login {}", usuario.getUsername());
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword());

            authenticationManager.authenticate(authenticationToken);

            // Removido o código relacionado ao token JWT

            return ResponseEntity.ok("Autenticação bem-sucedida para o usuário: " + usuario.getUsername());
        } catch (AuthenticationException ex) {
            log.warn("Credenciais inválidas para o username '{}'", usuario.getUsername());
            return ResponseEntity
                    .badRequest()
                    .body("Credenciais Inválidas");
        }
    }
}


