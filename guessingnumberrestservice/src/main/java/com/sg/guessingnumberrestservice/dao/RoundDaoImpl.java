
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.dto.Round;
import com.sg.guessingnumberrestservice.mappers.RoundMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoundDaoImpl implements RoundDao{
    
    @Autowired
    JdbcTemplate jdbc;
    
    //Yuliet --> "guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. 
    //It returns the Round object with the results filled in.

    @Override
    public Round addGuessToRound(int guess, Game game) {
        
        final String INSERT_ROUND = 
                "INSERT INTO round(guess, result, gameId) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_ROUND, guess, game.getAnswer(), game.getGameId());
        
        int newRoundId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return getRoundById(newRoundId);
    }
    
    @Override
    public Round getRoundById(int roundId) {
        try {
            final String SELECT_ROUND_BY_ID = "SELECT * FROM student WHERE id = ?";
            return jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), roundId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    //Michaela --> "rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.
    

    @Override
    public List<Round> getAllRounds() {
        String sql = "SELECT * FROM round;";

        return jdbc.query(sql, new RoundMapper()); 
    }
}
