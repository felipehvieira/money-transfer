package br.felipehenriques.transfermoney.Operacao.Factory;

import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServicoCliente;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServicoClienteComum;
import br.felipehenriques.transfermoney.Operacao.Servico.OperacaoServicoClienteLojista;
import br.felipehenriques.transfermoney.Usuario.entidade.TipoUsuario;
import org.springframework.stereotype.Component;

import java.nio.InvalidMarkException;

@Component
public class OperacaoFabrica {

     public OperacaoServicoCliente fabricaOperacao(TipoUsuario tipoUsuario){
         switch (tipoUsuario){
             case COMUM:
                 return new OperacaoServicoClienteComum();
             case LOJISTA:
                 return new OperacaoServicoClienteLojista();
                 //OpcaoInvalidaExcecao
             default: throw new InvalidMarkException();
         }
     }
}
