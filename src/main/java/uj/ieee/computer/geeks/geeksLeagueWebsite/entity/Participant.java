package uj.ieee.computer.geeks.geeksLeagueWebsite.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id") // Mapping the primary key to 'participant_id'
    private long id;
    
    @Column(name = "first_name") // Mapping the first name to 'first_name' column
    private String firstName;

    @Column(name = "last_name") // Mapping the last name to 'last_name' column
    private String lastName;

    @Column(name = "membership_id") // Mapping the membership ID to 'membership_id' column
    private long membershipId;

    @OneToMany(mappedBy = "participant")
    private List<Point> points;

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(long membershipId) {
        this.membershipId = membershipId;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
