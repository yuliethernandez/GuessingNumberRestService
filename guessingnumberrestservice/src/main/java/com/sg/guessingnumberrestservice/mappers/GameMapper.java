
package com.sg.guessingnumberrestservice.mappers;

import com.sg.guessingnumberrestservice.dto.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GameMapper implements RowMapper<Game>{

    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("gameId"));
        game.setAnswer(rs.getString("answer"));
        game.setStatusGame(rs.getBoolean("statusGame"));
        
        return game;
    }
    
}
