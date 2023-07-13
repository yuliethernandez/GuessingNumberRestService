
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.mappers.GameMapper;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GameDaoImpl implements GameDao{
    
    @Autowired
    JdbcTemplate jdbc;
     
    @Override
    public Game addGame(Game game) {
        final String INSERT_GAME = "INSERT INTO game(GameId, answer, statusGame) "
                + "VALUES(?,?,?)";
        
        jdbc.update(INSERT_GAME,
                game.getGameId(),
                game.getAnswer(),
                game.getStatusGame());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameId(newId);
        return game;
    }

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

    @Override
    public List<Game> getAllGames() {
        String sql = "SELECT * FROM game;";
        return jdbc.query(sql, new GameMapper());
    }

    @Override
    public void updateGame(Game game) {
        final String UPDATE_GAME = "UPDATE game SET statusGame = ? WHERE GameId = ?";
        jdbc.update(UPDATE_GAME, game.getStatusGame(), game.getGameId());
    }

    @Override
    @Transactional
    public void deleteGameById(int id) {
        final String DELETE_GAME = "DELETE FROM game WHERE GameId = ?;";
        jdbc.update(DELETE_GAME, id);
    }

}
