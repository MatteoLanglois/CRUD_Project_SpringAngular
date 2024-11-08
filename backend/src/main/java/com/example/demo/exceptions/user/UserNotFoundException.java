package com.example.demo.exceptions.user;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "L'utilisateur n'a pas été trouvé")
public class UserNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("L'utilisateur n'a pas été trouvé");
    }

}