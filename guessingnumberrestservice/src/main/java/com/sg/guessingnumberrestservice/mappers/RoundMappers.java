
package com.sg.guessingnumberrestservice.mappers;

import com.sg.guessingnumberrestservice.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

public class RoundMappers implements RowMapper<Round>{

    @Override
    public Round mapRow(ResultSet rs, int rowNum) throws SQLException {

        Round round = new Round();

        round.setRoundId(rs.getInt("RoundId"));
        round.setGuess(rs.getShort("guess"));
        round.setGuessTime(rs.getObject("guessTime", LocalDateTime.class));
        round.setResult(rs.getString("result"));
        round.setGameId(rs.getInt("GameId"));

        return round;
    }
    
}
