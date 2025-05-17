package uj.ieee.computer.geeks.geeksLeagueWebsite.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uj.ieee.computer.geeks.geeksLeagueWebsite.dto.LeaderBoardEntry;
import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Point;
import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.PointId;

public interface PointRepo extends JpaRepository<Point,PointId>{

    Optional<Point> findByParticipant_IdAndRound_Id(Long participantId, Long roundId);

    @Query("SELECT SUM(p.points) FROM Point p WHERE p.participant.id =:participantId")
    Optional<Integer> getTotalPointsByParticipant(@Param("participantId") Long participantId);


    //for global leaderboard
    @Query("""
        SELECT new uj.ieee.computer.geeks.geeksLeagueWebsite.dto.LeaderBoardEntry(
        p.participant.id,
        CONCAT(p.participant.firstName ,
        p.participant.lastName),
        SUM(p.points)
    )
    FROM Point p
    GROUP BY p.participant.id, p.participant.firstName, p.participant.lastName
    ORDER BY SUM(p.points) DESC
    """)
    List<LeaderBoardEntry> getLeaderboard();


    
    
    //round-specific leaderboard
    @Query("""
        SELECT new uj.ieee.computer.geeks.geeksLeagueWebsite.dto.LeaderBoardEntry(
            p.participant.id,
            CONCAT(p.participant.firstName ,
            p.participant.lastName),
            p.points
        )
        FROM Point p
        WHERE p.round.id =:roundId
        ORDER BY p.points DESC
    """)    
    List<LeaderBoardEntry> getLeaderboardByRound(@Param("roundId") Long roundId);


}
