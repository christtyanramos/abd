package br.com.abd.api.telefone.repository;

import br.com.abd.api.telefone.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>, TelefoneCustomRepository {
}
