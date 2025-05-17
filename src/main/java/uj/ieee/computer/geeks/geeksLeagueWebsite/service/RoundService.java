package uj.ieee.computer.geeks.geeksLeagueWebsite.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import uj.ieee.computer.geeks.geeksLeagueWebsite.dto.RoundDTO;
import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Round;
import uj.ieee.computer.geeks.geeksLeagueWebsite.enums.RoundStatus;
import uj.ieee.computer.geeks.geeksLeagueWebsite.exceptions.RoundNotFoundException;
import uj.ieee.computer.geeks.geeksLeagueWebsite.repo.RoundRepo;



@Service
public class RoundService{
    private final RoundRepo repo;

    public RoundService(RoundRepo repo) {
        this.repo = repo;
    }

    public Round findByIdRaw(long id){
        return repo.findById(id).orElseThrow(()->new RoundNotFoundException("Round \"%d\" not found".formatted(id)));
    }
    
    private RoundStatus getStatus(Round round){

        var now = LocalDate.now();
        if(round.getEndingDate().isBefore(now))return RoundStatus.FINISHED;
        if(round.getStartingDate().isBefore(now) && round.getEndingDate().isAfter(now))return RoundStatus.ACTIVE;
        else
        return RoundStatus.UPCOMING;

        
    }

    public RoundDTO findById(long id){
        var round = repo.findById(id).get();

        if(round == null)throw new RoundNotFoundException("Round \"%d\" not found".formatted(id));

        else
        return new RoundDTO(round.getId(), round.getTitle(), round.getStartingDate(), round.getEndingDate(), round.getDescription(),getStatus(round));
    }

    public Round findByTitle(String title){
        return repo.findByTitle(title).orElseThrow(()->new RoundNotFoundException("Round \"%s\" not found".formatted(title)));
    }

    public List<RoundDTO> findAll(){

        var allRounds=  repo.findAll();
        
        var allRoundsDto = new ArrayList<RoundDTO>() ;
        for(Round round :allRounds){
            allRoundsDto.add(new RoundDTO(round.getId(), round.getTitle(), round.getStartingDate(), round.getEndingDate(), round.getDescription(),getStatus(round)));
        }
        return allRoundsDto;
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
        Round round = findByIdRaw(id);
        round.setTitle(roundDetails.getTitle());
        round.setStartingDate(roundDetails.getStartingDate());
        round.setEndingDate(roundDetails.getEndingDate());
        round.setDescription(roundDetails.getDescription());
        return repo.save(round);
    }

    public void delete(long id) {
        Round round = findByIdRaw(id);
        repo.delete(round);
    }

}
