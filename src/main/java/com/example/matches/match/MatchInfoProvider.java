package com.example.matches.match;


import com.example.matches.utilities.ResultSpecifier;
import com.example.matches.utilities.SportKind;
import org.springframework.data.util.Pair;

import java.time.LocalDate;
import java.time.LocalTime;

public class MatchInfoProvider {

    private Integer match_id;
    private String description;
    private LocalDate match_date;
    private LocalTime match_time;
    private String team_a;
    private String team_b;
    private SportKind sport;

    private Integer odds_id;
    //private Integer match_id;
    private ResultSpecifier specifier;
    private Float odd;


    public MatchInfoProvider(Integer match_id, String description, LocalDate match_date,
                             LocalTime match_time, String team_a, String team_b,
                             SportKind sport, Integer odds_id,
                             ResultSpecifier specifier, Float odd) {
        this.match_id = match_id;
        this.description = description;
        this.match_date = match_date;
        this.match_time = match_time;
        this.team_a = team_a;
        this.team_b = team_b;
        this.sport = sport;
        this.odds_id = odds_id;
        this.specifier = specifier;
        this.odd = odd;
    }

    public Pair<Match, MatchOdds> createMatch() {
        var match = new Match(description,
                match_date,
                match_time,
                team_a,
                team_b,
                sport);

        var matchOdds = new MatchOdds(specifier, odd);
        match.setMatchOdds(matchOdds);
        matchOdds.setMatch(match);
        return Pair.of(match, matchOdds);

    }
}
