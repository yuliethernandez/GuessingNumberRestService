
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
    private RoundDao roundDao;
    
    @Autowired
    private GameDao gameDao;

    @Override
    public Round Guess(Round round) {
        Game game = gameDao.getGameById(round.getGameId());
        String answer = game.getAnswer();
        String guess = round.getGuess();
        String result = checkResult(guess, answer);
        round.setResult(result);
        
        if (guess.equals(answer)) {
            game.setStatusGame(true);
            gameDao.updateGame(game);
        }else{
            game.setStatusGame(false);
            gameDao.updateGame(game);
        }
        Round roundAdded = roundDao.addRound(round);
        return roundAdded;
    }

    private String checkResult(String guess, String answer) {
        int exact = 0;
        int partial = 0;
        
        if(guess.equals(answer)){
            exact = 4;
            partial = 0;
        }else{
            for (int i = 0; i < answer.length(); i++) {
                for (int j = 0; j < guess.length(); j++) {
                    if (guess.charAt(i) == answer.charAt(j)) {
                        if(i == j){
                            exact++;
                        } 
                        else {
                            partial++;
                        }                
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
