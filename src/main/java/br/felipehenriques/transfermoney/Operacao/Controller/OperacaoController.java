package br.felipehenriques.transfermoney.Operacao.Controller;

import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServico;
import br.felipehenriques.transfermoney.Operacao.entidade.dto.TransferenciaRequest;
import br.felipehenriques.transfermoney.Usuario.Servico.UsuarioServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacaoController {

    private final OperacaoServico servico;
    private final UsuarioServico usuarioServico;

    public OperacaoController(OperacaoServico servico, UsuarioServico usuarioServico) {
        this.servico = servico;
        this.usuarioServico = usuarioServico;
    }

    public void realizarTransferencia(TransferenciaRequest request){
//        Usuario usuario = new Usuario();
//        servico.tratarOperacoesRequest(request).transferir(usuario);
    }
    @GetMapping(value = "/saldo")
    public ResponseEntity<?> consultaSaldo(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServico.getSaldoUsuario());
    }
}
