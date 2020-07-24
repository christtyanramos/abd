package br.com.abd.api.usuario.service;

import br.com.abd.api.exception.HttpException;
import br.com.abd.api.telefone.entity.Telefone;
import br.com.abd.api.telefone.service.TelefoneService;
import br.com.abd.api.usuario.entity.Usuario;
import br.com.abd.api.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefoneService telefoneService;

    @Override
    public Usuario save(Usuario usuario) {

        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new HttpException("E-mail já existente", HttpStatus.CONFLICT);
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setData_criacao(new Date());
        usuario.setData_atualizacao(null);
        usuario.setUltimo_login(new Date());

        usuario = usuarioRepository.save(usuario);

        if (usuario.getTelefones() != null && !usuario.getTelefones().isEmpty()) {
            for (Telefone telefone : usuario.getTelefones()) {
                telefone.setUsuario_id(usuario.getId());
            }
            telefoneService.saveAll(usuario.getTelefones());
        }

        return usuario;
    }

}
