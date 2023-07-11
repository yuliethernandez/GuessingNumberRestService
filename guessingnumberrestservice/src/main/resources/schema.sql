DROP DATABASE IF EXISTS GuessNumberDB;
CREATE DATABASE GuessNumberDB;
USE GuessNumberDB;

CREATE TABLE game (
    GameId INT PRIMARY KEY AUTO_INCREMENT,
    answer char(4),
    statusGame BOOLEAN DEFAULT false
    );

CREATE TABLE round (
    RoundId INT PRIMARY KEY AUTO_INCREMENT,
    guess SMALLINT NOT NULL,
    guessTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    result CHAR(11),
    GameId INT NOT NULL,
    FOREIGN KEY fk_GameId (GameId) REFERENCES game(GameId)
    );