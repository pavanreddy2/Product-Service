package com.ar.productService.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomException extends RuntimeException{

    private String errorCode;
    private String errorMessage;
    private int status;


    public CustomException(String errorCode,String errorMessage,int status){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }
}
