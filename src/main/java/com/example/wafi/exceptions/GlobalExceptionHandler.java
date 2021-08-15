package com.example.wafi.exceptions;/*
 * @author Okala III
 */

import com.example.wafi.dto.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NoSuchElementException.class, IllegalArgumentException.class})
    protected ResponseEntity<?> handleConflict(Exception ex, WebRequest request) throws Exception {

        //add headers to be returned with response
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof IllegalArgumentException || ex instanceof NoSuchElementException ) {
            log.error(ex.getMessage());
            return new ResponseEntity<>(new AccountResponse(400,false, ex.getMessage()), HttpStatus.BAD_REQUEST);

        }

        else {
            // rethrow the given exception for further processing through the HandlerExceptionResolver chain.
            throw ex;
        }
    }
}