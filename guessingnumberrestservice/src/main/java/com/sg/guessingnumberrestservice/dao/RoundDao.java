
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.dto.Round;
import java.util.List;

public interface RoundDao {
    //Michaela --> "rounds/{gameId} – GET – Returns a list of rounds for 
    //the specified game sorted by time.
    
    //Yuliet --> "guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. It returns the Round object with the results filled in.
    Round addRound(String guess, Game game);
    
    Round getRoundById(int roundId);
    
    List<Round> getAllRounds();

    List<Round> getRoundsByGameId(int id);
}
