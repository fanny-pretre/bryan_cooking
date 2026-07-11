package com.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFound extends RuntimeException {

    public DataNotFound(String type, Object recherche) {
        super("L'element recherche n'a pas été trouvé - type " + type + " - critere de recherche :  " + recherche  );
    }
}