
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dao.RoundDao;
import com.sg.guessingnumberrestservice.dto.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundServiceImpl implements RoundService{

    @Autowired
    RoundDao roundDao;

    public List<Round> getRoundsByGameId(int id) {
        return roundDao.findRoundsByGameId(id);
    }
}
