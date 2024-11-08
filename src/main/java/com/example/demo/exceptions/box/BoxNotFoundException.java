package com.example.demo.exceptions.box;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "La boîte n'a pas été trouvée")
public class BoxNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public BoxNotFoundException() {
        super("La boîte n'a pas été trouvée");
    }
}