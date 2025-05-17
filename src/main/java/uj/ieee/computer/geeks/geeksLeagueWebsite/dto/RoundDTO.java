package uj.ieee.computer.geeks.geeksLeagueWebsite.dto;

import java.time.LocalDate;

import uj.ieee.computer.geeks.geeksLeagueWebsite.enums.RoundStatus;

//data transfer object to use for leader board
public record RoundDTO(long id , String title , LocalDate startDate , LocalDate endDate, String description ,RoundStatus status) {
    
}
