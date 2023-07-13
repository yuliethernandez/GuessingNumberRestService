
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.dto.Round;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameDaoImplTest {
    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;
    
    public GameDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Round> roundsToDelete = roundDao.getAllRounds();
        for (Round round: roundsToDelete) {
            roundDao.deleteRoundById(round.getRoundId());
        }
        List<Game> games = gameDao.getAllGames();
        for(Game game: games) {
            gameDao.deleteGameById(game.getGameId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllGames method, of class GameDaoImpl.
     */
    @Test
    public void testGetAllGames() {
        // Create three Game Objects with all the needed details
        // to add them to the database.
        Game game1 = new Game();
        game1.setAnswer("2014");
        game1.setStatusGame(Boolean.TRUE);
        game1 = gameDao.addGame(game1);

        Game game2 = new Game();
        game2.setAnswer("7045");
        game2.setStatusGame(Boolean.TRUE);
        game2 = gameDao.addGame(game2);

        Game game3 = new Game();
        game3.setAnswer("1264");
        game3.setStatusGame(Boolean.TRUE);
        game3 = gameDao.addGame(game3);

        List<Game> allGames = gameDao.getAllGames();

        // Tests if we retrieved 3 game objects
        Assertions.assertEquals(3, allGames.size());
        // Test if Game1 object is stored in our games list
        Assertions.assertTrue(allGames.contains(game1));
        // Test if Game2 object is stored in our games list
        Assertions.assertTrue(allGames.contains(game2));
        // Test if Game3 object is stored in our games list
        Assertions.assertTrue(allGames.contains(game3));
    }
    
    @Test
    public void testCreateAddGame() {
        Game game = new Game();
        game.setGameId(200);
        game.setAnswer("2014");
        game.setStatusGame(Boolean.TRUE);
        game = gameDao.addGame(game);
        
        Game added = gameDao.addGame(game);
        int gameId = added.getGameId();

        Game fromDao = gameDao.getGameById(gameId);

        assertEquals(game, fromDao);
    }

    /**
     * Test of getGameById method, of class GameDaoImpl.
     */
    @Test
    public void testGetGameById() {
        Game game = gameDao.getGameById(2);
        assertEquals(game, gameDao.getGameById(2));
    } 
}
