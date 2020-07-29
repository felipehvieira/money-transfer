package br.felipehenriques.transfermoney.Operacao.Servico;

import br.felipehenriques.transfermoney.Usuario.entidade.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface OperacaoServicoCliente {
    void transferir(Usuario usuario);
    void pagar(Usuario usuario);
}
