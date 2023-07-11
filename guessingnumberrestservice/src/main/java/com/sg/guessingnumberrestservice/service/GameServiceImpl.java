
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dao.GameDao;
import com.sg.guessingnumberrestservice.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GameServiceImpl implements GameService{
    @Autowired
    GameDao gameDao;

    public List<Game> getAllGames() {
        List<Game> allGames = gameDao.getAllGames();
        //Hide Answer for "In-Progress" games
        for (Game game : allGames) {
            if (game.getStatusGame().equals(true)) {
                game.setAnswer("****");
            } else {
            }
        }
        return allGames;
    }
    
    @Override
    public int generateAnswer() {

        HashSet<Integer> answer = new HashSet<>();
        Random numberGen = new Random();
        for (int i = 0; answer.size() < 4; i++) {
            answer.add(numberGen.nextInt(8) + 1);
        }

        String numberGuess = "";
        for (int i : answer) {
            numberGuess += i;
        }

        System.out.println(numberGuess);
        int num = Integer.parseInt(numberGuess);
        return num;
    }
}
