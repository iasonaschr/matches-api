package com.example.matches.match;

import com.example.matches.utilities.ResponseHandler;
import com.example.matches.utilities.ResultSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path = "api/v1/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping(path = "/api/v1/matches")
    public ResponseEntity<Object> getMatches() {
        var matches = matchService.getMatches();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, matches);

    }

    @GetMapping(path = "/api/v1/match/{matchId}")
    public ResponseEntity<Object> getMatchById(@PathVariable("matchId") Integer matchId) {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, matchService.getMatchById(matchId));

    }

    @PostMapping(path = "/api/v1/match")
    public ResponseEntity<Object> registerNewMatch(@RequestBody MatchInfoProvider m) {
        var matchInfo = m.createMatch();
        this.matchService.addNewMatch(matchInfo.getFirst());
        return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, null);

    }

    @DeleteMapping(path = "/api/v1/match/{matchId}")
    public ResponseEntity<Object> deleteMatch(@PathVariable("matchId") Integer matchId) {
        this.matchService.deleteMatchById(matchId);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, null);
    }

    //delete all matches before a previous date
    @DeleteMapping(path = "/api/v1/match")
    public ResponseEntity<Object> deleteMatchBeforeDate(@RequestParam(value = "date") String date) {
        this.matchService.deleteMatchBeforeDate(date);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, null);

    }


    @PutMapping(path = "/api/v1/match/{matchId}")
    public ResponseEntity<Object> updateMatchDateTime(@PathVariable("matchId") Integer matchId,
                                                      @RequestParam(value = "date", required = false) String newDate,
                                                      @RequestParam(value = "time", required = false) String newTime,
                                                      @RequestParam(value = "odd", required = false) Float newOdd,
                                                      @RequestParam(value = "specifier", required = false) ResultSpecifier newSpecifier) {
        this.matchService.updateMatch(matchId, newDate, newTime, newOdd, newSpecifier);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, null);
    }


}
