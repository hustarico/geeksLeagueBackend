package uj.ieee.computer.geeks.geeksLeagueWebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParticipantNotFoundException extends RuntimeException{

    public ParticipantNotFoundException() {
        super("Participant not found");
    }
    public ParticipantNotFoundException(String s) {
        super(s);
    }


    public ParticipantNotFoundException(Long id) {
        super("Participant number %d not found".formatted(id));
    }
}
