package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class OperacaoClienteComumServico implements OperacaoServicoCliente {

    @Override
    public void transferir(BigDecimal valorTransferencia, UUID usuarioOrigem, UUID usuarioDestino) {

    }

    @Override
    public void pagar(Usuario usuario) {

    }
}
