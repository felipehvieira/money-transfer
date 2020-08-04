package br.felipehenriques.transfermoney.Operacao.Factory;

import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoClienteComumServico;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoClienteLojistaServico;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServicoCliente;
import br.felipehenriques.transfermoney.Usuario.entidade.TipoUsuario;
import org.springframework.stereotype.Service;

import java.nio.InvalidMarkException;

@Service
public class OperacaoFabrica {

    private OperacaoClienteLojistaServico lojista;
    private OperacaoClienteComumServico comum;

    public OperacaoFabrica(OperacaoClienteLojistaServico lojista, OperacaoClienteComumServico comum) {
        this.lojista = lojista;
        this.comum = comum;
    }

    public OperacaoServicoCliente fabricaOperacao(TipoUsuario tipoUsuario){
         switch (tipoUsuario){
             case COMUM:
                 return comum;
             case LOJISTA:
                 return lojista;
                 //OpcaoInvalidaExcecao
             default: throw new InvalidMarkException();
         }
     }
}
