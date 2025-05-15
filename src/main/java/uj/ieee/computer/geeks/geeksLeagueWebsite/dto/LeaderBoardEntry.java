package uj.ieee.computer.geeks.geeksLeagueWebsite.dto;


//data transfer object to use for leader board
public record LeaderBoardEntry(Long participantId,String firstName,String lastName,long totalPoints) {

}
