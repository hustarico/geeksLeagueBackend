package uj.ieee.computer.geeks.geeksLeagueWebsite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Point {

    @EmbeddedId
    private PointId id;

    @ManyToOne
    @JoinColumn(name = "participant_id", insertable = false, updatable = false)
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "round_id", insertable = false, updatable = false)
    private Round round;

    @Column(name = "points")
    private int points;

    public PointId getId() {
        return id;
    }

    public void setId(PointId id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    

}
