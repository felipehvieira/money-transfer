package br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions;

public class ConflictException extends RuntimeException{
    public ConflictException(String mensagem){
        super(mensagem);
    }
}
