package uj.ieee.computer.geeks.geeksLeagueWebsite.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Participant;

public interface ParticipantRepo extends JpaRepository<Participant,Long>{


    @Query("select p from Participant p where p.firstName = :firstName and p.lastName = :lastName")
    Optional<Participant> findByFullName(@Param("firstName")String firstName,@Param("lastName") String lastName);
}
