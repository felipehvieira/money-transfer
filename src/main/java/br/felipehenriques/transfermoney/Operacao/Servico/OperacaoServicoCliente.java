package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public interface OperacaoServicoCliente {
    void transferir(BigDecimal valorTransferencia, UUID usuarioOrigem, UUID usuarioDestino);
    void pagar(Usuario usuario);
}
