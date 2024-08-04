package com.ar.productService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomerService(CustomException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(exception.getErrorCode());
        errorResponse.setErrorMessage(exception.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getStatus()));
    }
}
