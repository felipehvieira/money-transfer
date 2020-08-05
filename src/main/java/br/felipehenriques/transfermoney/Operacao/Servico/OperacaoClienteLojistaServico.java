package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Carteira.Client.CarteiraClient;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.BadRequestException;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.NotFoundException;
import br.felipehenriques.transfermoney.Usuario.Repositorio.UsuarioRepositorio;
import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class OperacaoClienteLojistaServico implements OperacaoServicoCliente {

    private UsuarioRepositorio repositorio;
    private CarteiraClient carteira;

    public OperacaoClienteLojistaServico() {
    }

    @Autowired
    public OperacaoClienteLojistaServico(UsuarioRepositorio repositorio, CarteiraClient carteira) {
        this.repositorio = repositorio;
        this.carteira = carteira;
    }

    @Override
    public void transferir(BigDecimal valorTransferencia, UUID usuarioOrigem, UUID usuarioDestino) {

        if(usuarioOrigem.equals(usuarioDestino))
            throw new BadRequestException("Não é possível reaizar uma transferencia a si mesmo.");

        Usuario origem = repositorio.findById(usuarioOrigem).orElseThrow(() -> new NotFoundException("Usuário Origem Inexistente."));
        Usuario destino = repositorio.findById(usuarioDestino).orElseThrow(() -> new NotFoundException("Usuário Destino Inexistente."));
        BigDecimal taxaTransferencia = new BigDecimal("5");
        //getSaldo usuarioOrigem
        //verifica se há saldo suficiente
        if (carteira.retornaSaldoCliente().getSaldo().compareTo(valorTransferencia.add(taxaTransferencia)) >= 0) {
            //realiza a transferencia
        } else
            throw new BadRequestException("Saldo Insuficiente.");

        //adiciona transferencia no extrato de origem e destino
    }

    @Override
    public void pagar(Usuario usuario) {

    }
}
