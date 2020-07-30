package br.felipehenriques.transfermoney.Carteira.Client;

import br.felipehenriques.transfermoney.Carteira.Domain.dto.SaldoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://demo6759613.mockable.io", name = "carteira")
public interface CarteiraClient {

    @GetMapping("/saldo")
    SaldoResponse retornaSaldoCliente();
}
