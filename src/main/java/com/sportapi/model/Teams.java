//package com.sportapi.model;
//
//
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "teams")
//public class Teams{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String teamName;
//
//    @Column
//    private String teamLogoPath;
//
//    @Column(nullable = false)
//    private String teamCaptain;
//
//    @Column(nullable = false)
//    private String teamCaptainContact;
//
//    // Constructors, getters, and setters
//
//    public Teams() {
//        // Default constructor
//    }
//
//    public Teams(String teamName, String teamLogoPath, String teamCaptain, String teamCaptainContact) {
//        this.teamName = teamName;
//        this.teamLogoPath = teamLogoPath;
//        this.teamCaptain = teamCaptain;
//        this.teamCaptainContact = teamCaptainContact;
//    }
//
//    // Getters and setters for all fields
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//
//        this.id = id;
//    }
//
//    public String getTeamName() {
//        return teamName;
//    }
//
//    public void setTeamName(String teamName) {
//        this.teamName = teamName;
//    }
//
//    public String getTeamLogoPath() {
//        return teamLogoPath;
//    }
//
//    public void setTeamLogoPath(String teamLogoPath) {
//        this.teamLogoPath = teamLogoPath;
//    }
//
//    public String getTeamCaptain() {
//        return teamCaptain;
//    }
//
//    public void setTeamCaptain(String teamCaptain) {
//        this.teamCaptain = teamCaptain;
//    }
//
//    public String getTeamCaptainContact() {
//        return teamCaptainContact;
//    }
//
//    public void setTeamCaptainContact(String teamCaptainContact) {
//        this.teamCaptainContact = teamCaptainContact;
//    }
//}
package com.sportapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String teamName;

    @Column
    private String teamLogoPath;

    @Column(nullable = false)
    private String teamCaptain;

    @Column(nullable = false)
    private String teamCaptainContact;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;



    @ManyToMany(mappedBy = "teams")
    private List<Pool> pools;
    // Constructors, getters, and setters

    public Teams() {
        // Default constructor
    }

    public Teams(String teamName, String teamLogoPath, String teamCaptain, String teamCaptainContact, Event event) {
        this.teamName = teamName;
        this.teamLogoPath = teamLogoPath;
        this.teamCaptain = teamCaptain;
        this.teamCaptainContact = teamCaptainContact;
        this.event = event;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLogoPath() {
        return teamLogoPath;
    }

    public void setTeamLogoPath(String teamLogoPath) {
        this.teamLogoPath = teamLogoPath;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public String getTeamCaptainContact() {
        return teamCaptainContact;
    }

    public void setTeamCaptainContact(String teamCaptainContact) {
        this.teamCaptainContact = teamCaptainContact;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
