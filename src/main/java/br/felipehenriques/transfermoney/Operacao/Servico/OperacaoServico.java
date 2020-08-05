package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Operacao.Factory.OperacaoFabrica;
import br.felipehenriques.transfermoney.Operacao.entidade.dto.TransferenciaRequest;
import br.felipehenriques.transfermoney.Usuario.Servico.UsuarioServico;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OperacaoServico {

    private UsuarioServico usuarioServico;
    private OperacaoFabrica fabrica;

    public OperacaoServico(UsuarioServico usuarioServico, OperacaoFabrica fabrica) {
        this.usuarioServico = usuarioServico;
        this.fabrica = fabrica;
    }

    public OperacaoServicoCliente realizarTransferencia(BigDecimal valorTransferencia, UUID idUsuarioOrigem, UUID idUsuarioDestino){
        Usuario usuarioOrigem = usuarioServico.findById(idUsuarioOrigem);
        OperacaoServicoCliente servico = fabrica.fabricaOperacao(usuarioOrigem.getTipoUsuario());
        servico = fabrica.fabricaOperacao(usuarioOrigem.getTipoUsuario());

        servico.transferir(valorTransferencia, idUsuarioOrigem, idUsuarioDestino);

        return servico;
    }
}
