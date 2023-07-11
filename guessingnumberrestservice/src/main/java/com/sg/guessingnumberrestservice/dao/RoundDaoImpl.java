
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Round;
import com.sg.guessingnumberrestservice.mappers.RoundMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoundDaoImpl implements RoundDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // STUB DATA, DELETE THIS LATER
    private void insertStubData() {
        jdbcTemplate.update("DELETE FROM round");

        jdbcTemplate.update("INSERT INTO round (guess, guessTime, result, GameId)\n" +
                "VALUES (1234, \"2023-07-09 10:00:00\", \"e:1:p:1\", 1),\n" +
                "       (2345, \"2023-06-05 11:25:00\", \"e:2:p:1\", 1),\n" +
                "       (3456, \"2023-03-01 09:45:00\", \"e:1:p:3\", 1);");

    }

    @Override
    public List<Round> getRoundsByGameId(int id) {
        insertStubData();

        String FIND_ROUNDS_BY_GAME_ID =
                "SELECT * FROM round WHERE gameId=?";
        return jdbcTemplate.query(FIND_ROUNDS_BY_GAME_ID, new RoundMappers(), id);
    }
}
