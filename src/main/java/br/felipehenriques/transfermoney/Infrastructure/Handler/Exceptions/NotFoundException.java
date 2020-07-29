package br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensagem) {
        super(mensagem);
    }
}
