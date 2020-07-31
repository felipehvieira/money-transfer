package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;

import java.math.BigDecimal;
import java.util.UUID;

public class OperacaoClienteComumServico implements OperacaoServicoCliente {

    @Override
    public void transferir(BigDecimal valorTransferencia, UUID usuarioOrigem, UUID usuarioDestino) {

    }

    @Override
    public void pagar(Usuario usuario) {

    }
}
