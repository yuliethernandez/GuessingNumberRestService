
package com.sg.guessingnumberrestservice.controller;

import com.sg.guessingnumberrestservice.dto.Round;
import com.sg.guessingnumberrestservice.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoundController {

    @Autowired
    RoundService roundService;

    @GetMapping("/rounds/{id}")
    public List<Round> getRoundsByGameId(@PathVariable int id) {

        return roundService.getRoundsByGameId(id);
    }
}