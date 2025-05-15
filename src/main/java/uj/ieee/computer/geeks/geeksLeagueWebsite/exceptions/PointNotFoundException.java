package uj.ieee.computer.geeks.geeksLeagueWebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PointNotFoundException extends RuntimeException{

    public PointNotFoundException() {
        super("Point not found");
    }
    public PointNotFoundException(String s) {
        super(s);
    }


    public PointNotFoundException(Long id) {
        super("Participant number %d not found".formatted(id));
    }
}
