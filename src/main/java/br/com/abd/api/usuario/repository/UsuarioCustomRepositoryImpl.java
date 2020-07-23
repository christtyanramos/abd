package br.com.abd.api.usuario.repository;

import br.com.abd.api.usuario.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class UsuarioCustomRepositoryImpl implements UsuarioCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario findByEmail(String email) {

        StringBuilder hql = new StringBuilder();

        hql.append("  FROM Usuario ");
        hql.append(" WHERE email = :email ");

        TypedQuery<Usuario> typedQuery = entityManager.createQuery(hql.toString(), Usuario.class);

        typedQuery.setParameter("email", email);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
