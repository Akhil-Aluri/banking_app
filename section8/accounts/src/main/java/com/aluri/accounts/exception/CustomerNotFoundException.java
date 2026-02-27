package com.aluri.accounts.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String customerName, String fieldName, String fieldValue){
        super(String.format("%s not found with the given input data %s : '%s'", customerName, fieldName, fieldValue));

    }
}
