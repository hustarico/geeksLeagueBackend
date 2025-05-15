package uj.ieee.computer.geeks.geeksLeagueWebsite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Participant;
import uj.ieee.computer.geeks.geeksLeagueWebsite.exceptions.ParticipantNotFoundException;
import uj.ieee.computer.geeks.geeksLeagueWebsite.repo.ParticipantRepo;

@Service
public class ParticipantService {

    private final ParticipantRepo repo;

    public ParticipantService(ParticipantRepo repo) {
        this.repo = repo;
    }

    public Participant findById(long id) {
        return repo.findById(id).orElseThrow(() -> new ParticipantNotFoundException(id));
    }

    public Participant createParticipant(Participant participant) {
        return repo.save(participant);
    }

    public Participant updateParticipant(long id, Participant participant) {
        Participant existingParticipant = repo.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));

        existingParticipant.setFirstName(participant.getFirstName());
        existingParticipant.setLastName(participant.getLastName());
        existingParticipant.setMembershipId(participant.getMembershipId());

        return repo.save(existingParticipant);
    }

    public void deleteParticipant(long id) {
        Participant participant = repo.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));

        repo.delete(participant);
    }

    public List<Participant> getAllParticipants() {
        return repo.findAll();
    }

    public Participant findByFirstAndLastName(String firstName, String lastName) {
    return repo.findByFullName(firstName, lastName).orElseThrow(() -> new ParticipantNotFoundException("First name: " + firstName + ", Last name: " + lastName));
}

}
