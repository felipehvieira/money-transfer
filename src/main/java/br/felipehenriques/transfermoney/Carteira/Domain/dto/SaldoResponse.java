package br.felipehenriques.transfermoney.Carteira.Domain.dto;

import java.math.BigDecimal;

public class SaldoResponse {

    private BigDecimal saldo;

    public SaldoResponse(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
