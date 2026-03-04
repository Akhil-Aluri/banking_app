package com.aluri.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CardAlreadyExistException extends RuntimeException{

    public CardAlreadyExistException(String message){
        super(message);
    }
}
