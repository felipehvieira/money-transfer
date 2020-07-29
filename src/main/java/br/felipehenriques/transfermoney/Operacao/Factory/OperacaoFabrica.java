package br.felipehenriques.transfermoney.Operacao.Factory;

import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServicoCliente;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoClienteComumServico;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoClienteLojistaServico;
import br.felipehenriques.transfermoney.Usuario.entidade.TipoUsuario;
import org.springframework.stereotype.Component;

import java.nio.InvalidMarkException;

@Component
public class OperacaoFabrica {

     public OperacaoServicoCliente fabricaOperacao(TipoUsuario tipoUsuario){
         switch (tipoUsuario){
             case COMUM:
                 return new OperacaoClienteComumServico();
             case LOJISTA:
                 return new OperacaoClienteLojistaServico();
                 //OpcaoInvalidaExcecao
             default: throw new InvalidMarkException();
         }
     }
}
