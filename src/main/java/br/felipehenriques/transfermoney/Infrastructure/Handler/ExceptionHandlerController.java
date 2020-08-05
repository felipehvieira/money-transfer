package br.felipehenriques.transfermoney.Infrastructure.Handler;

import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.BadRequestException;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.ConflictException;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.InternalErrorException;
import br.felipehenriques.transfermoney.Infrastructure.Handler.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseException> handlerNotFoundException(NotFoundException e) {
        ResponseException response = new ResponseException(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ResponseException> handlerConflictException(ConflictException e) {
        ResponseException response = new ResponseException(HttpStatus.CONFLICT.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseException> handlerBadRequestException(BadRequestException e) {
        ResponseException response = new ResponseException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<ResponseException> handlerInternalErrorException(InternalErrorException e) {
        ResponseException response = new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}