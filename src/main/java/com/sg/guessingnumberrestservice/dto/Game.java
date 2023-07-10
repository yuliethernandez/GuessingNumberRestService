
package com.sg.guessingnumberrestservice.dto;

import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class Game {
    private int gameId;
    private String answer;
    private Boolean statusGame;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.gameId;
        hash = 83 * hash + Objects.hashCode(this.answer);
        hash = 83 * hash + Objects.hashCode(this.statusGame);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return Objects.equals(this.statusGame, other.statusGame);
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getStatusGame() {
        return statusGame;
    }

    public void setStatusGame(Boolean statusGame) {
        this.statusGame = statusGame;
    }
}
