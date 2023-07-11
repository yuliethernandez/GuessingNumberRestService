INSERT INTO game(GameId, answer, statusGame) VALUES
    (1, "2971", true),
    (2, "9218", true),
    (3, "2345", true);

INSERT INTO round (guess, guessTime, result, GameId)
VALUES (1234, "2023-07-09 10:00:00", "e:1:p:1", 1),
       (2345, "2023-06-05 11:25:00", "e:2:p:1", 2),
       (3456, "2023-03-01 09:45:00", "e:1:p:3", 3);