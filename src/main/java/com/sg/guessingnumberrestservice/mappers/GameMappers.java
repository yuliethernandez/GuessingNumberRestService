
package com.sg.guessingnumberrestservice.mappers;

import com.sg.guessingnumberrestservice.dto.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GameMappers implements RowMapper<Game>{

    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
