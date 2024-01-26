package br.com.neuroconexao.neuroconexaobackend.repositories;

import br.com.neuroconexao.neuroconexaobackend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    UserDetails findByLogin(String login);

    Usuario save(Usuario usuario);
}