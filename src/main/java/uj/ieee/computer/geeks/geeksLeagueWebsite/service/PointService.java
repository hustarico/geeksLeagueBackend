package uj.ieee.computer.geeks.geeksLeagueWebsite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uj.ieee.computer.geeks.geeksLeagueWebsite.dto.LeaderBoardEntry;
import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Point;
import uj.ieee.computer.geeks.geeksLeagueWebsite.exceptions.PointNotFoundException;
import uj.ieee.computer.geeks.geeksLeagueWebsite.repo.PointRepo;

@Service
public class PointService {

    private PointRepo repo;

    public PointService(PointRepo repo) {
        this.repo = repo;
    }

    public int findByParticipant_IdAndRound_Id(Long participantId, Long roundId){
        return repo.findByParticipant_IdAndRound_Id(participantId, roundId)
        .orElseThrow(() -> new PointNotFoundException("Points for participant %d in round %d not found".formatted(participantId,roundId))).getPoints();
    }

    int getTotalPointsByParticipant(Long participantId){
        return repo.getTotalPointsByParticipant(participantId).orElse(0);
    }



    //this returns the point entity for further processing (helper method for the update method)
    private Point getPointEntity(Long participantId, Long roundId) {
        return repo.findByParticipant_IdAndRound_Id(participantId, roundId)
        .orElseThrow(() -> new PointNotFoundException("Points for participant %d in round %d not found".formatted(participantId,roundId)));
    }

    public Point updatePointsInRound(Long participantId, Long roundId, int newPoints) {
        Point point = getPointEntity(participantId, roundId);
        point.setPoints(newPoints);
        return repo.save(point);
    }


    public List<LeaderBoardEntry> getTotalLeaderboard() {
        return repo.getLeaderboard();
    }
    public List<LeaderBoardEntry> getLeaderboardByRound(Long roundId) {
        return repo.getLeaderboardByRound(roundId);
    }


}
