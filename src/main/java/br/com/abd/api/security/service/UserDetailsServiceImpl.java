package br.com.abd.api.security.service;

import br.com.abd.api.security.UserSS;
import br.com.abd.api.usuario.entity.Usuario;
import br.com.abd.api.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getSenha());
    }
}
