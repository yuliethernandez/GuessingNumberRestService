
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.dto.Round;
import com.sg.guessingnumberrestservice.mappers.GameMapper;
import com.sg.guessingnumberrestservice.mappers.RoundMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl implements GameDao{
    @Autowired
    JdbcTemplate jdbc;
    //Maryam --> "begin" - POST – Starts a game, generates an answer, and sets the correct status. 
    //Should return a 201 CREATED message as well as the created gameId.


    //Nathalie --> "game/{gameId}" - GET – Returns a specific game based on ID. 
    //Be sure in-progress games do not display their answer.
    @Override
    public Game getGameById(int id) {
        //-We surround our code with a try-catch
        //-This will catch the exception thrown if there is no Game with that ID, so we can return null in that situation.
        try{
            //-SELECT query string and use it in queryForObject to get the one Game we are searching for.
            final String GET_GAME_BY_ID = "SELECT * FROM game WHERE GameId = ?";
            return jdbc.queryForObject(GET_GAME_BY_ID , new GameMapper(), id);
        }
        catch (DataAccessException ex){
            return null;
        }
    }
    //Gabby --> "game" – GET – Returns a list of all games. 
    //Be sure in-progress games do not display their answer.
    
    @Override
    public List<Game> getAllGames() {
        String sql = "SELECT * FROM game;";

        List<Game> allGames = jdbc.query(sql, new GameMapper());
        //Hide Answer for "In-Progress" games
        for (Game game : allGames) {
            if(game.getStatusGame().equals(true)) {
                game.setAnswer(" ");
            }
        }
        return allGames;
    }

}
