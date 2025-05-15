package uj.ieee.computer.geeks.geeksLeagueWebsite.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uj.ieee.computer.geeks.geeksLeagueWebsite.entity.Round;

public interface RoundRepo extends JpaRepository<Round,Long>{

    @Query("select R from Round R where R.title = :title")
    Optional<Round> findByTitle(@Param("title") String title);

}
