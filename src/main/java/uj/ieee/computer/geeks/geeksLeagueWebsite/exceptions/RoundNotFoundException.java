package uj.ieee.computer.geeks.geeksLeagueWebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RoundNotFoundException extends RuntimeException{

    public RoundNotFoundException() {
        super("Round not found");
    }
    public RoundNotFoundException(String s) {
        super(s);
    }


    public RoundNotFoundException(Long id) {
        super("Round number %d not found".formatted(id));
    }
}
