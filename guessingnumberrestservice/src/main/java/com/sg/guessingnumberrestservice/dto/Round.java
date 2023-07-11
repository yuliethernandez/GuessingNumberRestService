
package com.sg.guessingnumberrestservice.dto;

import java.time.LocalDateTime;
import java.util.Objects;

//@Entity
public class Round {
    private int roundId;
    private short guess;
    private LocalDateTime guessTime;
    private String result;
    private int gameId;
    
    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public short getGuess() {
        return guess;
    }

    public void setGuess(short guess) {
        this.guess = guess;
    }

    public LocalDateTime getGuessTime() {
        return guessTime;
    }

    public void setGuessTime(LocalDateTime guessTime) {
        this.guessTime = guessTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGameId() {
        return gameId;
    }
    
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.roundId;
        hash = 53 * hash + this.guess;
        hash = 53 * hash + Objects.hashCode(this.guessTime);
        hash = 53 * hash + Objects.hashCode(this.result);
        hash = 53 * hash + this.gameId;
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
        final Round other = (Round) obj;
        if (this.roundId != other.roundId) {
            return false;
        }
        if (this.guess != other.guess) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        return Objects.equals(this.guessTime, other.guessTime);
    }
}
