package br.felipehenriques.transfermoney.Usuario.Repositorio;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {
}
