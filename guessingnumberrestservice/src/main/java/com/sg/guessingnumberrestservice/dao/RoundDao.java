
package com.sg.guessingnumberrestservice.dao;

import com.sg.guessingnumberrestservice.dto.Round;

import java.util.List;


public interface RoundDao {

    List<Round> getRoundsByGameId(int id);
}
