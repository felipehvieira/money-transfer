package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;

import java.math.BigDecimal;


public class OperacaoClienteLojistaServico implements OperacaoServicoCliente {
    @Override
    public void transferir(BigDecimal valorTransferencia, Usuario usuarioOrigem, Usuario usuarioDestino) {
        //getSaldo usuarioOrigem
        //verifica se há saldo suficiente
        //realiza a transferencia
        //adiciona transferencia no extrato de origem e destino
    }

    @Override
    public void pagar(Usuario usuario) {

    }
}
