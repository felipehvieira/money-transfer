package br.felipehenriques.transfermoney.Usuario.Repositorio;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {
}
