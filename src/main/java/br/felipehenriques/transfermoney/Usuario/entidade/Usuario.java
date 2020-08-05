package br.felipehenriques.transfermoney.Usuario.entidade;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Usuario {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @NotNull
    private String nomeCompleto;
    @NotNull(message = "Not null")
    @Column(unique = true)
    private String email;
    @NotNull
    @Column(unique = true)
    private String documento;
    @NotNull(message = "not null")
    private TipoUsuario tipoUsuario;
    @NotNull
    private String senha;

    public Usuario(){}

    public Usuario(UUID id,String nomeCompleto, String email, String documento, TipoUsuario tipoUsuario, String senha) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.documento = documento;
        this.tipoUsuario = tipoUsuario;
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;

    }
    public UUID getId() {
        return id;
    }
}
