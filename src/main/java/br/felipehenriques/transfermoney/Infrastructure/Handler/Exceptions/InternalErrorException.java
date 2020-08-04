package br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions;

public class InternalErrorException extends RuntimeException {
    public InternalErrorException(String mensagem){
        super(mensagem);
    }
}
