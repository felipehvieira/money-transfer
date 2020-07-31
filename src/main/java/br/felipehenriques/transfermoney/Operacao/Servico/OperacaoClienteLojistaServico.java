package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.Repositorio.UsuarioRepositorio;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;


public class OperacaoClienteLojistaServico implements OperacaoServicoCliente {

    private UsuarioRepositorio repositorio;

    public OperacaoClienteLojistaServico(){}

    public OperacaoClienteLojistaServico(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void transferir(BigDecimal valorTransferencia, UUID usuarioOrigem, UUID usuarioDestino) {
        Optional<Usuario> origem = repositorio.findById(usuarioOrigem);
        Optional<Usuario> destino = repositorio.findById(usuarioDestino);
        //getSaldo usuarioOrigem
        //verifica se há saldo suficiente
        //realiza a transferencia
        //adiciona transferencia no extrato de origem e destino
    }

    @Override
    public void pagar(Usuario usuario) {

    }
}
