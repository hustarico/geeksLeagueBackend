package uj.ieee.computer.geeks.geeksLeagueWebsite.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;

@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id") // Mapping the primary key to the column 'round_id'
    private long id;
    
    @Column(name = "title") // Mapping the title to 'title' column
    private String title;

    @Column(name = "starting_date") // Mapping the starting date to 'starting_date' column
    private LocalDate startingDate;

    @Column(name = "ending_date") // Mapping the ending date to 'ending_date' column
    private LocalDate endingDate;

    @Column(name = "description") // Mapping the description to 'description' column
    private String description;

    @OneToMany(mappedBy = "round")
    private List<Point> points;

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long roundId) {
        this.id = roundId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String roundTitle) {
        this.title = roundTitle;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
