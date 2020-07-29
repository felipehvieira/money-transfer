package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface OperacaoServicoCliente {
    void transferir(BigDecimal valorTransferencia, Usuario usuarioOrigem, Usuario usuarioDestino);
    void pagar(Usuario usuario);
}
