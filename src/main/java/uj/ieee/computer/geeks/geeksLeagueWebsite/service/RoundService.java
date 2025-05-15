package uj.ieee.computer.geeks.geeksLeagueWebsite.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;


import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Round;
import uj.ieee.computer.geeks.geeksLeagueWebsite.exceptions.RoundNotFoundException;
import uj.ieee.computer.geeks.geeksLeagueWebsite.repo.RoundRepo;

@Service
public class RoundService{
    private final RoundRepo repo;

    public RoundService(RoundRepo repo) {
        this.repo = repo;
    }
    
    public Round findById(long id){
        return repo.findById(id).orElseThrow(()->new RoundNotFoundException(id));
    }

    public Round findByTitle(String title){
        return repo.findByTitle(title).orElseThrow(()->new RoundNotFoundException("Round \"%s\" not found".formatted(title)));
    }

    public List<Round> findAll(){
        return repo.findAll();
    }

    public Round findActiveRound(){ 

        var now =  LocalDate.now();

        return repo.findAll().stream()
        .filter(r -> !r.getStartingDate().isAfter(now) && !r.getEndingDate().isBefore(now))
        .findFirst().orElseThrow(()->new RoundNotFoundException());
        
    }

    public Round save(Round round) {
        return repo.save(round);
    }

    public Round update(long id, Round roundDetails) {
        Round round = findById(id);
        round.setTitle(roundDetails.getTitle());
        round.setStartingDate(roundDetails.getStartingDate());
        round.setEndingDate(roundDetails.getEndingDate());
        round.setDescription(roundDetails.getDescription());
        return repo.save(round);
    }

    public void delete(long id) {
        Round round = findById(id);
        repo.delete(round);
    }

}
