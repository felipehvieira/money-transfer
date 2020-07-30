package br.felipehenriques.transfermoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransferMoneyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransferMoneyApplication.class, args);
    }
}
