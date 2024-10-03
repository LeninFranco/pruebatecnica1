package com.leninfranco.pruebatecnica1.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ErrorResponse> handleRestClientException(Exception ex){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                            .body(ErrorResponse.builder()
                                                .error("Error al consumir la API Externa")
                                                .status(HttpStatus.SERVICE_UNAVAILABLE.value())
                                                .message(ex.getMessage())
                                                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                                                .build());
    }
}
