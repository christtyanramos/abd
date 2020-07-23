package br.com.abd.api.usuario.repository;

import br.com.abd.api.usuario.entity.Usuario;

public interface UsuarioCustomRepository {

    Usuario findByEmail(String email);
}
