package com.example.matches.match;

import com.example.matches.utilities.ResultSpecifier;
import com.example.matches.utilities.exceptions.MatchNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MatchService {
    private static final Logger log = LoggerFactory.getLogger(MatchLoader.class);

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getMatches() {
        return matchRepository.findAll();

    }

    public Match getMatchById(Integer matchId) {
        return matchRepository.findById(matchId).orElseThrow(() -> new MatchNotFoundException(matchId));
    }

    public void addNewMatch(Match m) {
        var matchOpt = matchRepository.findDuplicateMatch(m.getTeam_a(), m.getTeam_b(), m.getMatch_date(), m.getMatch_time(), m.getSport());

        if (matchOpt.isPresent()) {
            throw new IllegalStateException("An entry for this match already exists");
        } else {
            matchRepository.save(m);
        }
    }


    public void deleteMatchById(Integer matchId) {
        var matchOpt = matchRepository.findById(matchId);
        if (!matchOpt.isPresent()) {
            log.warn("A match with id : {} does not exist", matchId);
            throw new MatchNotFoundException(matchId);
        } else {
            matchRepository.deleteById(matchId);
            log.info("{} \t has been deleted", matchOpt.get());
        }
    }

    public void deleteMatchBeforeDate(String date) {

        var beforeDate = LocalDate.parse(date);
        var matches = matchRepository.findAllBeforeDate(beforeDate);
        for (var m : matches) {
            matchRepository.deleteById(m.getId());
            log.info("{} \t has been deleted", m);
        }

    }

    @Transactional
    public void updateMatch(Integer matchId, String newDate, String newTime, Float newOdd, ResultSpecifier spec) {

        var matchOpt = matchRepository.findById(matchId).orElseThrow(() ->
                new MatchNotFoundException(matchId));


        if (newDate != null && !newDate.isEmpty()) {
            var date = LocalDate.parse(newDate);
            matchOpt.setMatch_date(date);
        }

        if (newTime != null && !newTime.isEmpty()) {
            var time = LocalTime.parse(newTime);
            matchOpt.setMatch_time(time);
        }

        if (newOdd != null && newOdd > 0F) {
            matchOpt.getMatchOdds().setOdd(newOdd);
        }

        if (spec != null) {
            matchOpt.getMatchOdds().setSpecifier(spec);
        }


    }
}
