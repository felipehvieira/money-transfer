package br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String mensagem){
        super(mensagem);
    }
}
