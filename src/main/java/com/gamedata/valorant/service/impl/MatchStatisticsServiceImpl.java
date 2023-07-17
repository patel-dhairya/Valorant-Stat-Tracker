package com.gamedata.valorant.service.impl;

import com.gamedata.valorant.dto.MatchStatisticsDTO;
import com.gamedata.valorant.entity.MatchStatisticsEntity;
import com.gamedata.valorant.repository.MatchStatisticsRepository;
import com.gamedata.valorant.service.MatchStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Make EntryServiceImpl class singleton instance to make it more memory efficient
@Service
public class MatchStatisticsServiceImpl implements MatchStatisticsService {

    @Autowired
    private MatchStatisticsRepository matchStatisticsRepository;

    @Override
    public MatchStatisticsDTO saveMatchStatistics(MatchStatisticsDTO matchStatisticsDTO) {


        MatchStatisticsEntity matchStatisticsEntity = new MatchStatisticsEntity();
        matchStatisticsEntity.setUserName(matchStatisticsDTO.getUserName());
        matchStatisticsEntity.setMatchID(matchStatisticsDTO.getMatchID());
        matchStatisticsEntity.setAgentName(matchStatisticsDTO.getAgentName());
        matchStatisticsEntity.setKills(matchStatisticsDTO.getKills());
        matchStatisticsEntity.setDeaths(matchStatisticsDTO.getDeaths());
        matchStatisticsEntity.setAssists(matchStatisticsDTO.getAssists());
        matchStatisticsEntity.setFirstKills(matchStatisticsDTO.getFirstDeaths());
        matchStatisticsEntity.setFirstDeaths(matchStatisticsDTO.getFirstDeaths());
        matchStatisticsEntity.setMatchScore(matchStatisticsDTO.getMatchScore());

        matchStatisticsRepository.save(matchStatisticsEntity);
        return null;
    }
}