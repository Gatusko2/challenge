package com.challenge1.module.exception.handler;

import com.challenge1.module.exception.LobException;
import com.lob.api.ApiException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class LobExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {LobException.class})
    public ResponseEntity<?> handlerLobException(LobException lobException, WebRequest request){
        return super.handleExceptionInternal(lobException,lobException.getMessage(),new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }

/*  This will not be able to implement I sawthat  ApiExtension extends to exception and not RunTimeException
    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<?> handlerLobApiException(ApiException apiException, WebRequest request){
        return super.handleExceptionInternal(apiException,apiException.getMessage(),new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);
    }*/
}
