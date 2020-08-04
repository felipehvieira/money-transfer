package br.felipehenriques.transfermoney.Usuario.entidade;

import java.util.UUID;

public class UsuarioBuilder {
    private UUID id;
    private String nomeCompleto;
    private String email;
    private String documento;
    private TipoUsuario tipoUsuario;
    private String senha;

    public UsuarioBuilder() {
    }

    public UsuarioBuilder nomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder documento(String documento) {
        this.documento = documento;
        return this;
    }

    public UsuarioBuilder tipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        return this;
    }

    public UsuarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario build() {
        return new Usuario(UUID.randomUUID(), nomeCompleto, email, documento, tipoUsuario, senha);
    }
}
