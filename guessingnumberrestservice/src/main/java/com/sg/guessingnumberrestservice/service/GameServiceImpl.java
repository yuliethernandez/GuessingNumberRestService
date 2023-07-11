
package com.sg.guessingnumberrestservice.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService{
    
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
