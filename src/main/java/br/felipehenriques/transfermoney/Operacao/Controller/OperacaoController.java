package br.felipehenriques.transfermoney.Operacao.Controller;

import br.felipehenriques.transfermoney.Operacao.Factory.OperacaoFabrica;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServico;
import br.felipehenriques.transfermoney.Operacao.entidade.dto.TransferenciaRequest;
import br.felipehenriques.transfermoney.Usuario.Servico.UsuarioServico;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperacaoController {

    @Autowired
    private OperacaoServico servico;
    @Autowired
    private UsuarioServico usuarioServico;

    public void realizarTransferencia(TransferenciaRequest request){
        Usuario usuario = new Usuario();
        servico.tratarOperacoesRequest(request).transferir(usuario);
    }
}
