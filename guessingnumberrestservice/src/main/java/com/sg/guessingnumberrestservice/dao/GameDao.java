
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import java.util.List;


public interface GameDao {
    Game getGameById(int id) ;
    
    List<Game> getAllGames();
}
