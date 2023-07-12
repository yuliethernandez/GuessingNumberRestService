
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.dto.Round;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoundDaoImplTest {
    
    @Autowired
    GameDao gameDao;
    
    @Autowired
    RoundDao roundDao;
    
    public RoundDaoImplTest() {
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
        for (Round r : roundsToDelete) {
            roundDao.deleteRoundById(r.getRoundId());
        }

    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addRound method, of class RoundDaoImpl. Yuliet
     */
    @Test
    public void testAddRound() {
        // make a test game
        Game testGame = new Game();
        testGame.setGameId(1);
        testGame.setAnswer("2514");
        testGame.setStatusGame(false);
        
        gameDao.addGame(testGame);
        
        Round roundTest = new Round();
        roundTest.setGuess("5289");
        roundTest.setResult("e:0:p:2");
        roundTest.setGameId(1);
        
        Round roundAdded = roundDao.addRound(roundTest);
        Round roundFromDao = roundDao.getRoundById(roundAdded.getRoundId());
         /* Test of getRoundById method, of class RoundDaoImpl. */
        assertNotNull(roundAdded);
        assertEquals(roundAdded, roundFromDao);
    }

    /**
     * Test of getAllRounds method, of class RoundDaoImpl.
     */
   @Test
    public void testGetAllRounds() {
        // Create two Game Objects with all the needed details
        // to add them to the test database.
        Game game1 = new Game();
        game1.setAnswer("2014");
        game1.setStatusGame(Boolean.TRUE);
        game1 = gameDao.addGame(game1);

        Game game2 = new Game();
        game2.setAnswer("7045");
        game2.setStatusGame(Boolean.TRUE);
        game2 = gameDao.addGame(game2);


        // Create two Round Objects with all the needed details
        // to add them to the test database
        Round round1 = new Round();
        round1.setGameId(game1.getGameId());
        round1.setGuess("3735");
        round1.setResult("e:0:p:0");
        round1 = roundDao.addRound(round1);

        Round round2 = new Round();
        round2.setGameId(game1.getGameId());
        round2.setGuess("6821");
        round2.setResult("e:0:p:0");
        round2 = roundDao.addRound(round2);

        // Get a list of round objects
        List<Round> allRounds = roundDao.getAllRounds();


        // Tests if we retrieved 2 game objects
        Assertions.assertEquals(2, allRounds.size());
        // Test if Round1 object is stored in our round list
        Assertions.assertTrue(allRounds.contains(round1));
        // Test if Round2 object is stored in our round list
        Assertions.assertTrue(allRounds.contains(round2));
    }

    /**
     * Test of getRoundsByGameId method, of class RoundDaoImpl.
     */
    
    
    @Test
    @DisplayName("Test get rounds by GameId")
    public void testGetRoundsByGameId() {
        // set default values for a game and some guesses
        int TEST_GAME_ID = 100;
        String[] TEST_GUESSES = {"9876", "5432", "1098"};

        // make a test game
        Game testGame = new Game();
        testGame.setGameId(TEST_GAME_ID);
        testGame.setAnswer("0713");
        testGame.setStatusGame(false);
        
        gameDao.addGame(testGame);

        // make test rounds
        Round firstRound = new Round();
        firstRound.setGameId(TEST_GAME_ID);
        firstRound.setGuess(TEST_GUESSES[0]);

        Round secondRound = new Round();
        secondRound.setGameId(TEST_GAME_ID);
        secondRound.setGuess(TEST_GUESSES[1]);

        Round thirdRound = new Round();
        thirdRound.setGameId(TEST_GAME_ID);
        thirdRound.setGuess(TEST_GUESSES[2]);

        // insert the rounds into the DB
        roundDao.addRound(firstRound);
        roundDao.addRound(secondRound);
        roundDao.addRound(thirdRound);

        // did we get the right number of rounds?
        List<Round> result = roundDao.getRoundsByGameId(TEST_GAME_ID);
        assertEquals(3, result.size());

        // are all the rounds retrieved the correct ones?
        for (Round r : result) {
            assertEquals(TEST_GAME_ID, r.getGameId());
        }
    }
    
}
