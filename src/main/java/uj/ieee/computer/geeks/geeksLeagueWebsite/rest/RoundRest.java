package uj.ieee.computer.geeks.geeksLeagueWebsite.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uj.ieee.computer.geeks.geeksLeagueWebsite.dto.LeaderBoardEntry;
import uj.ieee.computer.geeks.geeksLeagueWebsite.dto.RoundDTO;
import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Round;
import uj.ieee.computer.geeks.geeksLeagueWebsite.service.PointService;
import uj.ieee.computer.geeks.geeksLeagueWebsite.service.RoundService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/rounds")
public class RoundRest {

    private final RoundService rounds;
    private final PointService points;


    

    public RoundRest(RoundService rounds, PointService points) {
        this.rounds = rounds;
        this.points = points;
    }

    @GetMapping("/active")
    public Round getActiveRound() {
        return rounds.findActiveRound();
    }
    
    @GetMapping("/leaderboard")
    public List<LeaderBoardEntry> getGlobalLeaderBoard() {
        return points.getTotalLeaderboard();
    }
    @GetMapping("/{roundId}/leaderboard")
    public List<LeaderBoardEntry> getLeaderboardByRound(@PathVariable Long roundId) {
        return points.getLeaderboardByRound(roundId);
    }
    
    @GetMapping("/all")
    public List<RoundDTO> getAllRounds() {
        return rounds.findAll();
    }

    @GetMapping("/{id}")
    public RoundDTO getRoundById(@PathVariable int id) {
        return rounds.findById(id);
    }

    
    
    

    

}