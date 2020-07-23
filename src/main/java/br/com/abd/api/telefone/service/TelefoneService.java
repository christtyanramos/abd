package br.com.abd.api.telefone.service;

import br.com.abd.api.telefone.entity.Telefone;

import java.util.List;

public interface TelefoneService {

    List<Telefone> saveAll(List<Telefone> telefones);
}
