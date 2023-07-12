
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Round;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoundDaoImplTest {
    
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

    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addRound method, of class RoundDaoImpl. Yuliet
     */
    @Test
    public void testAddRound() {
        Round roundTest = new Round();
        roundTest.setGuess("4789");
        roundTest.setResult("e:0:p:0");
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
    }

    /**
     * Test of getRoundsByGameId method, of class RoundDaoImpl.
     */
    @Test
    public void testGetRoundsByGameId() {
    }
    
}
