package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;

import java.math.BigDecimal;

public class OperacaoClienteComumServico implements OperacaoServicoCliente {

    @Override
    public void transferir(BigDecimal valorTransferencia, Usuario usuarioOrigem, Usuario usuarioDestino) {

    }

    @Override
    public void pagar(Usuario usuario) {

    }
}
