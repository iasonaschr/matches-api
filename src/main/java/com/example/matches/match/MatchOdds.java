package com.example.matches.match;

import com.example.matches.utilities.ResultSpecifier;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class MatchOdds {

    @Id
    @SequenceGenerator(
            name = "matchOdds_sequence",
            sequenceName = "matchOdds_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "matchOdds_sequence"
    )
    private Integer id;
    @NotNull
    private ResultSpecifier specifier;
    @NotNull
    private Float odd;

    //todo: make sure the cascade type is what I need here
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id", referencedColumnName = "id", nullable = false)
    private Match match;


    public MatchOdds(ResultSpecifier specifier, Float odd) {
        this.specifier = specifier;
        this.odd = odd;
    }

    public MatchOdds() {

    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

//    public Integer getMatch_id() {
//        return match_id;
//    }
//
//    public void setMatch_id(Integer match_id) {
//        this.match_id = match_id;
//    }

    public ResultSpecifier getSpecifier() {
        return specifier;
    }

    public void setSpecifier(ResultSpecifier specifier) {
        this.specifier = specifier;
    }

    public Float getOdd() {
        return odd;
    }

    public void setOdd(float odd) {
        this.odd = odd;
    }

    public void setOdd(Float odd) {
        this.odd = odd;
    }

//    public Match getMatch() {
//        return match;
//    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "MatchOdds{" +
                "id=" + id +
                // ", match_id=" + match_id +
                ", specifier=" + specifier +
                ", odd=" + odd +
                '}';
    }
}

