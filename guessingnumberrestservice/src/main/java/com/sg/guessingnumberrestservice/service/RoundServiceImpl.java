
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dao.GameDao;
import com.sg.guessingnumberrestservice.dao.RoundDao;
import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.dto.Round;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService{
    
    @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameDao gameDao;

    @Override
    public Round Guess(Round round) {
        String answer = gameDao.getGameById(round.getGameId()).getAnswer();
        String guess = round.getGuess();
        String result = checkResult(guess, answer);
        round.setResult(result);
        
        if (guess.equals(answer)) {
            Game game = gameDao.getGameById(round.getGameId());
            game.setStatusGame(false);
            gameDao.updateGame(game);
        }
        Game game = gameDao.getGameById(round.getGameId());
        Round roundAdded;
        roundAdded = roundDao.addRound(guess, game);
        return roundAdded;
    }

    private String checkResult(String guess, String answer) {
        
        char[] guessArray = guess.toCharArray();
        char[] answerArray = answer.toCharArray();
        
        int exact = 0;
        int partial = 0;
        
        for (int i = 0; i < guessArray.length; i++) {
            for (int j = 0; j < answerArray.length; j++) {
                if (guessArray[i] == answerArray[i]) {
                    if(i == j){
                        exact++;
                    } else {
                        partial++;
                    }                
                }
            }
        }
        
        String result = "e:" + exact + ":p:" + partial;
        
        return result;
    }

    @Override
    public List<Round> getRoundsByGameId(int id) {
        return roundDao.getRoundsByGameId(id);
    }
}
