package br.felipehenriques.transfermoney.Usuario.Controller;

import br.felipehenriques.transfermoney.Usuario.Servico.UsuarioServico;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UsuarioController {

    private UsuarioServico servico;

    public UsuarioController(UsuarioServico servico) {
        this.servico = servico;
    }

    @PostMapping(value = "/usuario")
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario usuarioRequest){
        Usuario usuario = servico.salvar(usuarioRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
