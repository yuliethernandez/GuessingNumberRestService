
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import java.util.List;


public interface GameDao {
    
    Game createNewGame();
            
    Game getGameById(int id) ;
    
    List<Game> getAllGames();
    
    Game addGame(Game game) ;

    public void updateGame(Game game);
}
