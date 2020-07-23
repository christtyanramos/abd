package br.com.abd.api.usuario.repository;

import br.com.abd.api.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioCustomRepository {
}
