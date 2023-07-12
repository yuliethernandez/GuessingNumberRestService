
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCreateAddGame() {
        Game game = gameDao.createNewGame();
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

    /**
     * Test of getAllGames method, of class GameDaoImpl.
     */
    @Test
    public void testGetAllGames() {
    }

    /**
     * Test of updateGame method, of class GameDaoImpl.
     */
    @Test
    public void testUpdateGame() {
    }
    
}
