package br.felipehenriques.transfermoney.Infrastructure.Handler;

public class ResponseException {

    private int codigoErro;
    private String descricaoError;

    public ResponseException(int codigoErro, String descricaoError) {
        this.codigoErro = codigoErro;
        this.descricaoError = descricaoError;
    }
    public int getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(int codigoErro) {
        this.codigoErro = codigoErro;
    }

    public String getDescricaoError() {
        return descricaoError;
    }

    public void setDescricaoError(String descricaoError) {
        this.descricaoError = descricaoError;
    }
}
