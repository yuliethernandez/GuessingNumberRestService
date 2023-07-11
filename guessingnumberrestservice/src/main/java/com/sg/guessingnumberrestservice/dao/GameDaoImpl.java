package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.mappers.GameMappers;
import com.sg.guessingnumberrestservice.service.GameService;
import com.sg.guessingnumberrestservice.service.GameServiceImpl;
import java.util.HashSet;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public class GameDaoImpl implements GameDao {
//Maryam --> "begin" - POST – Starts a game, generates an answer, and sets the correct status. 
//Should return a 201 CREATED message as well as the created gameId.

 

    @Autowired
    JdbcTemplate jdbc;

    
    @Override
    @Transactional
    public Game addGame(Game game) {
        final String INSERT_GAME = "INSERT INTO game(gameid, answer, statusGame) "
                + "VALUES(?,?,?)";
        
        jdbc.update(INSERT_GAME,
                game.getGameId(),
                game.getAnswer(),
                game.getStatusGame());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameId(newId);
        return game;
    }
 
//    private String generateAnswer() {
//
//        HashSet<Integer> answer = new HashSet<>();
//        Random numberGen = new Random();
//        for (int i = 0; answer.size() < 4; i++) {
//            answer.add(numberGen.nextInt(8) + 1);
//        }
//
//        String numberGuess = "";
//        for (int i : answer) {
//            numberGuess += i;
//        }
//
//     
//       
//        return numberGuess;
//    
//    }
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity newGame(@RequestBody Game todo) {
//        return dao.add(todo);
//    }
//Yuliet --> "guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
//The program must calculate the results of the guess and mark the game finished if the guess is correct. It returns the Round object with the results filled in.
//Gabby --> "game" – GET – Returns a list of all games. 
//Be sure in-progress games do not display their answer.
//Nathalie --> "game/{gameId}" - GET – Returns a specific game based on ID. 
//Be sure in-progress games do not display their answer.
//Michaela --> "rounds/{gameId} – GET – Returns a list of rounds for 
//the specified game sorted by time.

//    @Override
//    public Game createNewGame() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
