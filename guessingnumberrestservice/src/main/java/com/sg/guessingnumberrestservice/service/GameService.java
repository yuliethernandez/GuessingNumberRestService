
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dto.Game;

public interface GameService {
    int generateAnswer();
    Game getGameById(int GameId);
}
