package com.example.matches.match;

import com.example.matches.utilities.SportKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    @Query("SELECT id from Match WHERE team_a = ?1 and team_b = ?2 AND match_date = ?3 AND match_time = ?4 and sport = ?5")
        //@Query("SELECT s from Match WHERE s.team_a = ?1 and s.team_b = ?2")
    Optional<Integer> findDuplicateMatch(String teamA, String teamB, LocalDate md, LocalTime mt, SportKind sport);

    @Query(value = "SELECT * FROM Match WHERE match_date < ?1", nativeQuery = true)
    List<Match> findAllBeforeDate(LocalDate date);

}
