
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dao.GameDao;
import com.sg.guessingnumberrestservice.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    GameDao gameDao;
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

    @Override
    public Game getGameById(int GameId) {
        Game game = gameDao.getGameById(GameId);
        if (!game.getStatusGame()) {
            game.setAnswer("****");
        }

        return game;
    }
}
