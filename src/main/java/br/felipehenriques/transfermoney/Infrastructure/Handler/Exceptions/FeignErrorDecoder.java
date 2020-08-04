package br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 404:
                return new NotFoundException(response.body().toString());
            case 400:
                return new BadRequestException(response.reason());
            default:
                return new NotFoundException("Feign Decoder");
        }

    }
}
