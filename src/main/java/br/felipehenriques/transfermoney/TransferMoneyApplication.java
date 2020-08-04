package br.felipehenriques.transfermoney;

import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.FeignErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class TransferMoneyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransferMoneyApplication.class, args);
    }
    @Bean
    public FeignErrorDecoder errorDecoder(){
        return new FeignErrorDecoder();
    }
}
