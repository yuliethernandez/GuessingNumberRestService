package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameDaoTest {
    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createNewGame() {
    }

    @Test
    void getGameById() {
        Game game = gameDao.getGameById(2);
        assertEquals(game, gameDao.getGameById(2));
    }

    @Test
    void getAllGames() {
    }

    @Test
    void addGame() {
    }

    @Test
    void updateGame() {
    }
}