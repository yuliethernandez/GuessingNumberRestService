
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dto.Game;
import java.util.Random;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface GameService {
    
   public Game startNewGame();
   public String generateAnswer();
        
}
