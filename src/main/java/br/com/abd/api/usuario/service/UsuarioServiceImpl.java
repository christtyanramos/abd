package br.com.abd.api.usuario.service;

import br.com.abd.api.exception.HttpException;
import br.com.abd.api.security.JWTUtil;
import br.com.abd.api.security.SenhaUtil;
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

    @Autowired
    private JWTUtil jwtUtil;

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

        String token = jwtUtil.generateToken(usuario.getEmail());
        usuario.setToken(token);
        usuario = usuarioRepository.save(usuario);

        if (usuario.getTelefones() != null && !usuario.getTelefones().isEmpty()) {
            for (Telefone telefone : usuario.getTelefones()) {
                telefone.setUsuario_id(usuario.getId());
            }
            telefoneService.saveAll(usuario.getTelefones());
        }

        return usuario;
    }

    public Usuario login(String email, String password) {

        Usuario entity = usuarioRepository.findByEmail(email);

        if (entity == null || !SenhaUtil.validPassword(password, entity.getSenha())) {
            throw new HttpException("Usuário e/ou senha inválidos", HttpStatus.UNAUTHORIZED);
        }

        entity.setData_atualizacao(new Date());
        entity.setUltimo_login(new Date());

        return usuarioRepository.save(entity);

    }

}
