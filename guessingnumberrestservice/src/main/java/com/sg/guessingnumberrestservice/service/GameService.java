
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dto.Game;

public interface GameService {
    
    String generateAnswer();

    public Game addGame(Game game);

    public Game getGameById(int GameId);

    public Game startNewGame();
}
