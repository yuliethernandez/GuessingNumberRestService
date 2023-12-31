
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Round;
import com.sg.guessingnumberrestservice.mappers.RoundMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoundDaoImpl implements RoundDao{
    
    @Autowired
    private JdbcTemplate jdbc;
    
    //Yuliet --> "guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. 
    //It returns the Round object with the results filled in.

    @Override
    public Round addRound(Round round) {
        
        final String INSERT_ROUND = 
                "INSERT INTO round(guess, result, GameId) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_ROUND, round.getGuess(), round.getResult(), round.getGameId());
        
        int newRoundId = jdbc.queryForObject("SELECT LAST_INSERT_ID();", Integer.class);
        Round roundGet = getRoundById(newRoundId);

        return roundGet;
    }
    
    @Override
    public Round getRoundById(int roundId) {
        try {
            final String SELECT_ROUND_BY_ID = "SELECT * FROM round WHERE RoundId = ?;";
            return jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), roundId);
        } 
        catch (DataAccessException ex) {
            return null;
        }
    }
    
    //Gaby
    @Override
    public List<Round> getAllRounds() {
        String sql = "SELECT * FROM round;";

        return jdbc.query(sql, new RoundMapper()); 
    }
    
    //Michaela --> "rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.
    @Override
    public List<Round> getRoundsByGameId(int id) {
        String FIND_ROUNDS_BY_GAME_ID =
                "SELECT * FROM round WHERE GameId = ? ORDER BY guessTime";
        return jdbc.query(FIND_ROUNDS_BY_GAME_ID, new RoundMapper(), id);
    }

    @Override
    public void deleteRoundById(int id) {
        jdbc.update("DELETE FROM round WHERE RoundId = ?", id);
    }
}
