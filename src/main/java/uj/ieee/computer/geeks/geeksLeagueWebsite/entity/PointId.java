package uj.ieee.computer.geeks.geeksLeagueWebsite.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PointId implements Serializable{

    private Long participant_id;
    private Long round_id;

    public PointId() {}

    public PointId(Long participant, Long round) {
        this.participant_id = participant;
        this.round_id = round;
    }

    public Long getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Long participant) {
        this.participant_id = participant;
    }

    public Long getRound_id() {
        return round_id;
    }

    public void setRound_id(Long round) {
        this.round_id = round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointId pointId = (PointId) o;
        return Objects.equals(participant_id, pointId.participant_id) &&
            Objects.equals(round_id, pointId.round_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant_id, round_id);
    }
}
