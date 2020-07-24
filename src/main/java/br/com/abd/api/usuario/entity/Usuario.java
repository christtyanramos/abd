package br.com.abd.api.usuario.entity;

import br.com.abd.api.telefone.entity.Telefone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -4593497438317795120L;

    @Id
    @GeneratedValue(generator = "SEQ_TB_USUARIO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_TB_USUARIO", sequenceName = "SEQ_TB_USUARIO")
    @Column(name = "CD_USUARIO", nullable = false, unique = true)
    private Long id;

    @Column(name = "DS_NOME")
    private String nome;

    @Column(name = "DS_EMAIL")
    private String email;

    @Column(name = "DS_SENHA")
    private String senha;

    @Column(name = "DT_CRIACAO")
    private Date data_criacao;

    @Column(name = "DT_ATUALIZACAO")
    private Date data_atualizacao;

    @Column(name = "DT_ULTIMO_LOGIN")
    private Date ultimo_login;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();

    public Usuario() {
        super();
    }

    public Usuario(Long id, String nome, String email, String senha, Date data_criacao, Date data_atualizacao, Date ultimo_login) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.data_criacao = data_criacao;
        this.data_atualizacao = data_atualizacao;
        this.ultimo_login = ultimo_login;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
