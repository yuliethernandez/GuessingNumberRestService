
package com.sg.guessingnumberrestservice.controller;

import com.sg.guessingnumberrestservice.dto.Round;
import com.sg.guessingnumberrestservice.service.RoundService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoundController {
    
    @Autowired
    RoundService roundService;
    
    @PostMapping("/guess")
    public Round makeGuess(@RequestBody Round round) {
        return roundService.Guess(round);   
    }

    @GetMapping("/rounds/{id}")
    public List<Round> getRoundsByGameId(@PathVariable int id) {
        return roundService.getRoundsByGameId(id);
    }
    
}
