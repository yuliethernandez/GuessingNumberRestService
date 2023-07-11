
package com.sg.guessingnumberrestservice.mappers;

import com.sg.guessingnumberrestservice.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoundMappers implements RowMapper<Round>{

    @Override
    public Round mapRow(ResultSet rs, int rowNum) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
