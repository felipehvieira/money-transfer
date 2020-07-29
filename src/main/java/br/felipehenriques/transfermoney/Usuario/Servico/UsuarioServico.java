package br.felipehenriques.transfermoney.Usuario.Servico;

import br.felipehenriques.transfermoney.Usuario.Repositorio.UsuarioRepositorio;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio repositorio;

    protected Usuario salvar(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public Usuario findById(UUID idUsuario){
        //Criar Exception Handler
        return repositorio.findById(idUsuario).orElse(null);
    }
}
