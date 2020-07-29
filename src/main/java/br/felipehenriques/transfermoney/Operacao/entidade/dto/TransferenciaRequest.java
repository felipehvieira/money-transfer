package br.felipehenriques.transfermoney.Operacao.entidade.dto;

import br.felipehenriques.transfermoney.Usuario.entidade.TipoUsuario;

import java.math.BigDecimal;
import java.util.UUID;

public class TransferenciaRequest {

    private UUID idUsuarioOrigem;
    private UUID idUsuarioDestino;
    private BigDecimal valorTransferencia;

    public UUID getIdUsuarioOrigem() {
        return idUsuarioOrigem;
    }

    public void setIdUsuarioOrigem(UUID idUsuarioOrigem) {
        this.idUsuarioOrigem = idUsuarioOrigem;
    }

    public UUID getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    public void setIdUsuarioDestino(UUID idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }

    public BigDecimal getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(BigDecimal valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }
}
