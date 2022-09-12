package com.example.matches.match;

import com.example.matches.utilities.ResultSpecifier;
import com.example.matches.utilities.SportKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class MatchLoader {
    private static final Logger log = LoggerFactory.getLogger(MatchLoader.class);

    @Bean
    CommandLineRunner initMatchDb(MatchRepository repo) {
        return args -> {
            log.info("Loading matches to DB...");
            var paoOsfp = new Match(
                    "PAO-OSFP",
                    LocalDate.of(2022, Month.SEPTEMBER, 6),
                    LocalTime.of(18, 30),
                    "PAO",
                    "OSFP",
                    SportKind.FOOTBALL);

            var paoOsfpOdds = new MatchOdds(ResultSpecifier.A, 1.05F);
            paoOsfp.setMatchOdds(paoOsfpOdds);
            paoOsfpOdds.setMatch(paoOsfp);
            var arisPaok = new Match(
                    "ARIS-PAOK",
                    LocalDate.of(2022, Month.SEPTEMBER, 7),
                    LocalTime.of(21, 30),
                    "ARIS",
                    "PAOK",
                    SportKind.FOOTBALL);

            var arisPaokOdds = new MatchOdds(ResultSpecifier.X, 2.5F);
            arisPaok.setMatchOdds(arisPaokOdds);
            arisPaokOdds.setMatch(arisPaok);
            repo.saveAll(List.of(paoOsfp, arisPaok));
        };
    }
}


