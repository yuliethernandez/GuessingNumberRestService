
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import java.util.List;


public interface GameDao {
    
    Game createNewGame();
            
    Game getGameById(int id) ;
    
    List<Game> getAllGames();
    
    Game addGame(Game game) ;

    void updateGame(Game game);
    
    // This method to be inserted in GAMEDAO interface
    void deleteGameById(int id);
}
