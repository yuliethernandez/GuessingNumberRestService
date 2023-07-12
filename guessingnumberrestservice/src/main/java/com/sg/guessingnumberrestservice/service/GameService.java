
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dto.Game;
import java.util.List;

public interface GameService {

    Game getGameById(int GameId);

    Game startNewGame();

    List<Game> getAllGames();
}
