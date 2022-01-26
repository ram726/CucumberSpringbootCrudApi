package com.example.BddSpringboot.cucumber;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecordNotFound extends Throwable {
    public RecordNotFound() {
    }
    public RecordNotFound(String message){
        super(message);
    }
}
