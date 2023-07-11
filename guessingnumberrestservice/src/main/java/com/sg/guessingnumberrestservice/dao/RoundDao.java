
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Round;

import java.util.List;


import com.sg.guessingnumberrestservice.dto.Game;

public interface RoundDao {

    List<Round> getRoundsByGameId(int id);
    //Michaela --> "rounds/{gameId} – GET – Returns a list of rounds for
    //the specified game sorted by time.

    //Yuliet --> "guess" – POST – Makes a guess by passing the guess and gameId in as JSON.
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. It returns the Round object with the results filled in.
    Round addGuessToRound(int guess, Game game);

    Round getRoundById(int roundId);

    List<Round> getAllRounds();
}
