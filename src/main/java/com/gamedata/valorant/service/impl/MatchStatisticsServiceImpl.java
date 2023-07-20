// Service layer in CSR data architecture(Controller, Service, Repository)
package com.gamedata.valorant.service.impl;

import com.gamedata.valorant.converter.MatchStatisticsConverter;
import com.gamedata.valorant.dto.MatchStatisticsDTO;
import com.gamedata.valorant.entity.MatchStatisticsEntity;
import com.gamedata.valorant.repository.MatchStatisticsRepository;
import com.gamedata.valorant.service.MatchStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// Make EntryServiceImpl class singleton instance to make it more memory efficient
@Service
public class MatchStatisticsServiceImpl implements MatchStatisticsService {

    @Autowired
    private MatchStatisticsRepository matchStatisticsRepository;

    @Autowired
    private MatchStatisticsConverter matchStatisticsConverter;

    @Override
    public MatchStatisticsDTO saveMatchStatistics(MatchStatisticsDTO matchStatisticsDTO) {

        MatchStatisticsEntity matchStatisticsEntity = matchStatisticsConverter.convertDTO(matchStatisticsDTO);
        // Send the data to repository layer
        matchStatisticsEntity = matchStatisticsRepository.save(matchStatisticsEntity);
        matchStatisticsDTO = matchStatisticsConverter.convertEntity(matchStatisticsEntity);
        return matchStatisticsDTO;
    }

    @Override
    public List<MatchStatisticsDTO> getAllStatistics() {
        List<MatchStatisticsDTO> matchStatisticsDTOList = new ArrayList<>();

        // Find all user entries in entity format and convert to DTO to return back to controller
        List<MatchStatisticsEntity> matchStatisticsEntityList = (List<MatchStatisticsEntity>)matchStatisticsRepository.findAll();
        for(MatchStatisticsEntity matchStatisticsEntity: matchStatisticsEntityList){
            MatchStatisticsDTO matchStatisticsDTO = matchStatisticsConverter.convertEntity(matchStatisticsEntity);
            matchStatisticsDTOList.add(matchStatisticsDTO);
        }
        return matchStatisticsDTOList;
    }

    @Override
    public MatchStatisticsDTO updateMatchStatistics(MatchStatisticsDTO newMatchStatisticsDTO, Long entryID) {
        // Return type of findById is optional in case entry does not exist
        Optional<MatchStatisticsEntity> matchStatisticsEntityOptional = matchStatisticsRepository.findById(entryID);
        MatchStatisticsDTO updatedDTO = null;
        // Check if valid entry exist for given entryID
        if(matchStatisticsEntityOptional.isPresent()){
            MatchStatisticsEntity matchStatisticsEntity = matchStatisticsEntityOptional.get();
            matchStatisticsEntity.setAgentName(newMatchStatisticsDTO.getAgentName());
            matchStatisticsEntity.setAssists(newMatchStatisticsDTO.getAssists());
            matchStatisticsEntity.setUserName(newMatchStatisticsDTO.getUserName());
            matchStatisticsEntity.setMatchID(newMatchStatisticsDTO.getMatchID());
            matchStatisticsEntity.setKills(newMatchStatisticsDTO.getKills());
            matchStatisticsEntity.setDeaths(newMatchStatisticsDTO.getDeaths());
            matchStatisticsEntity.setAssists(newMatchStatisticsDTO.getAssists());
            matchStatisticsEntity.setFirstKills(newMatchStatisticsDTO.getFirstDeaths());
            matchStatisticsEntity.setFirstDeaths(newMatchStatisticsDTO.getFirstDeaths());
            matchStatisticsEntity.setUserScore(newMatchStatisticsDTO.getUserScore());
            matchStatisticsEntity.setOpponentScore(newMatchStatisticsDTO.getOpponentScore());

            updatedDTO = matchStatisticsConverter.convertEntity(matchStatisticsEntity);
            // save the new updated entry
            matchStatisticsRepository.save(matchStatisticsEntity);
        }
        return updatedDTO;
    }


}