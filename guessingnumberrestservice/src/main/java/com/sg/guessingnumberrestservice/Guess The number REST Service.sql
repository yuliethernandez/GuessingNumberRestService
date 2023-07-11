DROP DATABASE IF EXISTS GuessNumberDB;
CREATE DATABASE GuessNumberDB;
USE GuessNumberDB;

CREATE TABLE game (
	GameId INT PRIMARY KEY AUTO_INCREMENT,
    answer CHAR(4),
    statusGame BOOLEAN DEFAULT false
    );

CREATE TABLE round (
	RoundId INT PRIMARY KEY AUTO_INCREMENT,
    guess INT NOT NULL,    
    guessTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    
    result CHAR(11),
    GameId INT NOT NULL,
    FOREIGN KEY fk_GameId (GameId) REFERENCES game(GameId)
    );
    
INSERT INTO game(GameId, answer, statusGame) VALUES
    (1, "2971", true),
    (2, "9218", true),
    (3, "2345", true);
    
INSERT INTO round (guess, guessTime, result, GameId)
VALUES (1895, "2023-07-09 10:00:00", "e:1:p:1", 1),
		(2347, "2023-06-05 11:25:00", "e:2:p:1", 2),
		(1458, "2023-03-01 09:45:00", "e:1:p:3", 3);