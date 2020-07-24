package br.com.abd.api.telefone.entity;

import br.com.abd.api.usuario.entity.Usuario;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TB_TELEFONE")
public class Telefone implements Serializable {

    private static final long serialVersionUID = -2406055461208684857L;

    @Id
    @GeneratedValue(generator = "SEQ_TB_TELEFONE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_TB_TELEFONE", sequenceName = "SEQ_TB_TELEFONE", allocationSize = 1)
    @Column(name = "CD_TELEFONE", nullable = false)
    private Long id;

    @Column(name = "CD_USUARIO", nullable = false)
    private Long usuario_id;

    @Column(name = "DS_NUMERO", length = 9)
    private String numero;

    @Column(name = "DS_DDD", length = 2)
    private String ddd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_USUARIO", nullable = false, insertable = false, updatable = false)
    private Usuario usuario;

    public Telefone() {
        super();
    }

    public Telefone(Long id, Long usuario_id, String numero, String ddd) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.numero = numero;
        this.ddd = ddd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
