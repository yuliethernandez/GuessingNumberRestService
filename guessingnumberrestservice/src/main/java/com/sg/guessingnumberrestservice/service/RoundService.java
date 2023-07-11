
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dto.Round;

import java.util.List;

public interface RoundService {

    List<Round> getRoundsByGameId(int id);
}
