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
}