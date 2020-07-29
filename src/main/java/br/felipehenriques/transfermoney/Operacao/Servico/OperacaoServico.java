package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Operacao.Factory.OperacaoFabrica;
import br.felipehenriques.transfermoney.Operacao.entidade.dto.TransferenciaRequest;
import br.felipehenriques.transfermoney.Usuario.Servico.UsuarioServico;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacaoServico {

    @Autowired
    private UsuarioServico usuarioServico;
    @Autowired
    private OperacaoFabrica fabrica;

    public OperacaoServicoCliente tratarOperacoesRequest(TransferenciaRequest transferenciaRequest){
        Usuario usuarioOrigem = usuarioServico.findById(transferenciaRequest.getIdUsuarioOrigem());
        OperacaoServicoCliente servico = fabrica.fabricaOperacao(usuarioOrigem.getTipoUsuario());

        return servico;
    }
}
