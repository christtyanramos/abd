package br.com.abd.api.db.service;

import br.com.abd.api.telefone.entity.Telefone;
import br.com.abd.api.telefone.repository.TelefoneRepository;
import br.com.abd.api.usuario.entity.Usuario;
import br.com.abd.api.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
public class DBServiceImpl implements DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public void instantiateTestDatabase() {

        Usuario usuario1 = new Usuario(null, "Christtyan Ramos", "christtyanr@gmail.com",
                "teste123", new Date(), null, new Date());

        Usuario usuario2 = new Usuario(null, "João Pedro", "joaop@gmail.com",
                "teste12345", new Date(), null, new Date());

        usuario1 = usuarioRepository.save(usuario1);

        usuario2 = usuarioRepository.save(usuario2);

        Telefone telefone1 = new Telefone(null, usuario1.getId(), "998162881", "81");

        Telefone telefone2 = new Telefone(null, usuario2.getId(), "999998888", "81");

        Telefone telefone3 = new Telefone(null, usuario2.getId(), "997886644", "81");

        telefoneRepository.saveAll(Arrays.asList(telefone1, telefone2, telefone3));

    }
}
