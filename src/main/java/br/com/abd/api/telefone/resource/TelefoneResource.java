package br.com.abd.api.telefone.resource;

import br.com.abd.api.telefone.entity.Telefone;
import br.com.abd.api.usuario.resource.UsuarioResource;

import java.io.Serializable;

public class TelefoneResource implements Serializable {

    private static final long serialVersionUID = 4672036037935814333L;

    private Long id;

    private String numero;

    private String ddd;

    private UsuarioResource usuario;

    public TelefoneResource() {
        super();
    }

    public TelefoneResource(Telefone entity) {

        this.setId(entity.getId());
        this.setNumero(entity.getNumero());
        this.setDdd(entity.getDdd());

        if (entity.getUsuario() != null) {

            UsuarioResource usuario = new UsuarioResource();
            usuario.setId(entity.getUsuario().getId());

            this.setUsuario(usuario);
        }
    }

    public Telefone toEntity() {

        Telefone entity = new Telefone();

        entity.setId(this.getId());
        entity.setNumero(this.getNumero().trim());
        entity.setDdd(this.getDdd().trim());
        entity.setUsuario_id(this.getUsuario() != null ? this.getUsuario().getId() : null);

        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public UsuarioResource getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResource usuario) {
        this.usuario = usuario;
    }
}
