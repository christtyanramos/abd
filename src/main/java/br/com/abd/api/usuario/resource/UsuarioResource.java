package br.com.abd.api.usuario.resource;

import br.com.abd.api.telefone.entity.Telefone;
import br.com.abd.api.telefone.resource.TelefoneResource;
import br.com.abd.api.usuario.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioResource implements Serializable {

    private static final long serialVersionUID = 1673152061571550809L;

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String senha;

    private Date data_criacao;

    private Date data_atualizacao;

    private Date ultimo_login;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TelefoneResource> telefones = new ArrayList<>();

    public UsuarioResource() {
        super();
    }

    public UsuarioResource(Usuario entity) {

        this.setId(entity.getId());
        this.setData_criacao(entity.getData_criacao());
        this.setData_atualizacao(entity.getData_atualizacao());
        this.setUltimo_login(entity.getUltimo_login());
    }

    public Usuario toEntity() {

        Usuario entity = new Usuario();

        entity.setId(this.getId());
        entity.setNome(this.getNome() != null ? this.getNome().trim() : null);
        entity.setEmail(this.getEmail() != null ? this.getEmail().trim().toLowerCase() : null);
        entity.setSenha(this.getSenha());

        if (this.getTelefones() != null && !this.getTelefones().isEmpty()) {

            for (TelefoneResource telefoneResource : this.getTelefones()) {
                Telefone telefone = telefoneResource.toEntity();
                telefone.setUsuario(entity);
                entity.getTelefones().add(telefone);
            }
        }

        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Date data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

    public Date getUltimo_login() {
        return ultimo_login;
    }

    public void setUltimo_login(Date ultimo_login) {
        this.ultimo_login = ultimo_login;
    }

    public List<TelefoneResource> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneResource> telefones) {
        this.telefones = telefones;
    }
}
