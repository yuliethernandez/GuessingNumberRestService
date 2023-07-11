
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dto.Game;
import java.util.List;

public interface GameService {
    
    String generateAnswer();

    public Game addGame(Game game);

    public Game getGameById(int GameId);

    public Game startNewGame();

    public List<Game> getAllGames();
}
