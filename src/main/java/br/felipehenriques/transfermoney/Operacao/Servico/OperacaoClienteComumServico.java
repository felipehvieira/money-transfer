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
public class OperacaoClienteComumServico implements OperacaoServicoCliente {

    private UsuarioRepositorio usuarioRepositorio;
    private CarteiraClient carteira;

    @Autowired
    public OperacaoClienteComumServico(UsuarioRepositorio usuarioRepositorio, CarteiraClient carteira) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.carteira = carteira;
    }

    @Override
    public void transferir(BigDecimal valorTransferencia, UUID usuarioOrigem, UUID usuarioDestino) {
        Usuario origem = usuarioRepositorio.findById(usuarioOrigem).orElseThrow(() -> new NotFoundException("Usuário Inexistente."));
        Usuario destino = usuarioRepositorio.findById(usuarioDestino).orElseThrow(() -> new NotFoundException("Usuário Inexistente."));
        //getSaldo usuarioOrigem
        //verifica se há saldo suficiente
        if (carteira.retornaSaldoCliente().getSaldo().compareTo(valorTransferencia) >= 0) {
            //realiza a transferencia
        } else
            throw new BadRequestException("Saldo Insuficiente.");

        //adiciona transferencia no extrato de origem e destino
    }

    @Override
    public void pagar(Usuario usuario) {

    }
}
