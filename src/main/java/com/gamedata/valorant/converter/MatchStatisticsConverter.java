// This class will handle conversation of dto to entity to transfer data from controller to repository and vice versa

package com.gamedata.valorant.converter;


import com.gamedata.valorant.dto.MatchStatisticsDTO;
import com.gamedata.valorant.entity.MatchStatisticsEntity;
import org.springframework.stereotype.Component;

@Component
public class MatchStatisticsConverter {
    public MatchStatisticsEntity convertDTO(MatchStatisticsDTO matchStatisticsDTO){
        // Adapter design pattern as Repository layer expects Entity but controller layer sends DTO
        // Take data from controller layer in format of DTO and save it as Entity
        MatchStatisticsEntity matchStatisticsEntity = new MatchStatisticsEntity();
        matchStatisticsEntity.setMatchID(matchStatisticsDTO.getMatchID());
        matchStatisticsEntity.setAgentName(matchStatisticsDTO.getAgentName());
        matchStatisticsEntity.setKills(matchStatisticsDTO.getKills());
        matchStatisticsEntity.setDeaths(matchStatisticsDTO.getDeaths());
        matchStatisticsEntity.setAssists(matchStatisticsDTO.getAssists());
        matchStatisticsEntity.setFirstKills(matchStatisticsDTO.getFirstDeaths());
        matchStatisticsEntity.setFirstDeaths(matchStatisticsDTO.getFirstDeaths());
        matchStatisticsEntity.setUserScore(matchStatisticsDTO.getUserScore());
        matchStatisticsEntity.setOpponentScore(matchStatisticsDTO.getOpponentScore());

        return matchStatisticsEntity;
    }

    public MatchStatisticsDTO convertEntity(MatchStatisticsEntity matchStatisticsEntity){

        // Take data in entity form and convert it to DTO to send it to controller layer.
        MatchStatisticsDTO matchStatisticsDTO = new MatchStatisticsDTO();
        matchStatisticsDTO.setId(matchStatisticsEntity.getId());
        matchStatisticsDTO.setMatchID(matchStatisticsEntity.getMatchID());
        matchStatisticsDTO.setAgentName(matchStatisticsEntity.getAgentName());
        matchStatisticsDTO.setKills(matchStatisticsEntity.getKills());
        matchStatisticsDTO.setDeaths(matchStatisticsEntity.getDeaths());
        matchStatisticsDTO.setAssists(matchStatisticsEntity.getAssists());
        matchStatisticsDTO.setFirstKills(matchStatisticsEntity.getFirstDeaths());
        matchStatisticsDTO.setFirstDeaths(matchStatisticsEntity.getFirstDeaths());
        matchStatisticsDTO.setUserScore(matchStatisticsEntity.getUserScore());
        matchStatisticsDTO.setOpponentScore(matchStatisticsEntity.getOpponentScore());

        return matchStatisticsDTO;
    }
}
