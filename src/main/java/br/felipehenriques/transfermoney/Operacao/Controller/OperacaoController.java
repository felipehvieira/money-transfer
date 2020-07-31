package br.felipehenriques.transfermoney.Operacao.Controller;

import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServico;
import br.felipehenriques.transfermoney.Operacao.entidade.dto.TransferenciaRequest;
import br.felipehenriques.transfermoney.Usuario.Servico.UsuarioServico;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacaoController {

    private final OperacaoServico servico;
    private final UsuarioServico usuarioServico;

    public OperacaoController(OperacaoServico servico, UsuarioServico usuarioServico) {
        this.servico = servico;
        this.usuarioServico = usuarioServico;
    }
    //ResponseEntity<TransferenciaResponse>
    @PostMapping("/transferir")
    public ResponseEntity<?> realizarTransferencia(@RequestBody TransferenciaRequest request){
        servico.realizarTransferencia(request.getValorTransferencia(), request.getIdUsuarioOrigem(), request.getIdUsuarioDestino());

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
    @GetMapping(value = "/saldo")
    public ResponseEntity<?> consultaSaldo(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServico.getSaldoUsuario());
    }
}
