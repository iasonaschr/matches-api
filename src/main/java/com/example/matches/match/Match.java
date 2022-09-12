package com.example.matches.match;

import com.example.matches.utilities.SportKind;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Match {

    @Id
    @SequenceGenerator(
            name = "match_sequence",
            sequenceName = "match_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "match_sequence"
    )
    private Integer id;
    private String description;
    private LocalDate match_date;
    private LocalTime match_time;
    private String team_a;
    private String team_b;
    private SportKind sport;

    @OneToOne(mappedBy = "match", cascade = CascadeType.ALL)
    private MatchOdds matchOdds;

    public Match(
            String description,
            LocalDate match_date,
            LocalTime match_time,
            String team_a,
            String team_b,
            SportKind sport) {

        this.description = description;
        this.match_date = match_date;
        this.match_time = match_time;
        this.team_a = team_a;
        this.team_b = team_b;
        this.sport = sport;
    }

    public Match() {

    }

    //turn to protected if you don't want it to be deserialized by jackson
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getMatch_date() {
        return match_date;
    }

    public LocalTime getMatch_time() {
        return match_time;
    }

    public String getTeam_a() {
        return team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public SportKind getSport() {
        return sport;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMatch_date(LocalDate match_date) {
        this.match_date = match_date;
    }

    public void setMatch_time(LocalTime match_time) {
        this.match_time = match_time;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public void setSport(SportKind sport) {
        this.sport = sport;
    }

    public MatchOdds getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(MatchOdds matchOdds) {
        this.matchOdds = matchOdds;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", match_date=" + match_date +
                ", match_time=" + match_time +
                ", team_a='" + team_a + '\'' +
                ", team_b='" + team_b + '\'' +
                ", sport=" + sport + '\'' +
//                ", specifier=" + matchOdds.getSpecifier().toString() + '\'' +
//                ", odd=" + matchOdds.getOdd().toString() +
                '}';
    }

//    public enum SportKind {
//        FOOTBALL(1),
//        BASKETBALL(2);
//
//        public final int val;
//
//        private SportKind(int val) {
//            this.val = val;
//        }
//
//        @Override
//        public String toString() {
//            return String.valueOf(this.val);
//        }
//    }
}
