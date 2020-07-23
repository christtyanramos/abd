package br.com.abd.api.telefone.service;

import br.com.abd.api.telefone.entity.Telefone;
import br.com.abd.api.telefone.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Override
    public List<Telefone> saveAll(List<Telefone> telefones) {
        return telefoneRepository.saveAll(telefones);
    }
}
