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
            matchStatisticsEntity.setFirstKills(newMatchStatisticsDTO.getFirstKills());
            matchStatisticsEntity.setFirstDeaths(newMatchStatisticsDTO.getFirstDeaths());
            matchStatisticsEntity.setUserScore(newMatchStatisticsDTO.getUserScore());
            matchStatisticsEntity.setOpponentScore(newMatchStatisticsDTO.getOpponentScore());

            updatedDTO = matchStatisticsConverter.convertEntity(matchStatisticsEntity);
            // save the new updated entry
            matchStatisticsRepository.save(matchStatisticsEntity);
        }
        return updatedDTO;
    }

    @Override
    public MatchStatisticsDTO partialUpdateMatchStatistics(MatchStatisticsDTO partialMatchStatisticsDTO, Long entryId) {
        // Return type of findById is optional in case entry does not exist
        Optional<MatchStatisticsEntity> matchStatisticsEntityOptional = matchStatisticsRepository.findById(entryId);
        MatchStatisticsDTO updatedDTO = null;

        // Check if valid entry exists for given entryId
        if (matchStatisticsEntityOptional.isPresent()) {
            MatchStatisticsEntity matchStatisticsEntity = matchStatisticsEntityOptional.get();
            // Check if at least one field is non-null in the partialMatchStatisticsDTO
            if (isAnyFieldNonNull(partialMatchStatisticsDTO)) {
                // Check which fields are present in the partialMatchStatisticsDTO and update them accordingly
                Optional.ofNullable(partialMatchStatisticsDTO.getAgentName()).ifPresent(matchStatisticsEntity::setAgentName);
                Optional.ofNullable(partialMatchStatisticsDTO.getAssists()).ifPresent(matchStatisticsEntity::setAssists);
                Optional.ofNullable(partialMatchStatisticsDTO.getUserName()).ifPresent(matchStatisticsEntity::setUserName);
                Optional.ofNullable(partialMatchStatisticsDTO.getMatchID()).ifPresent(matchStatisticsEntity::setMatchID);
                Optional.ofNullable(partialMatchStatisticsDTO.getKills()).ifPresent(matchStatisticsEntity::setKills);
                Optional.ofNullable(partialMatchStatisticsDTO.getDeaths()).ifPresent(matchStatisticsEntity::setDeaths);
                Optional.ofNullable(partialMatchStatisticsDTO.getFirstKills()).ifPresent(matchStatisticsEntity::setFirstKills);
                Optional.ofNullable(partialMatchStatisticsDTO.getFirstDeaths()).ifPresent(matchStatisticsEntity::setFirstDeaths);
                Optional.ofNullable(partialMatchStatisticsDTO.getUserScore()).ifPresent(matchStatisticsEntity::setUserScore);
                Optional.ofNullable(partialMatchStatisticsDTO.getOpponentScore()).ifPresent(matchStatisticsEntity::setOpponentScore);
                updatedDTO = matchStatisticsConverter.convertEntity(matchStatisticsEntity);
                matchStatisticsRepository.save(matchStatisticsEntity);
            }
        }
        return updatedDTO;
    }

    private boolean isAnyFieldNonNull(MatchStatisticsDTO matchStatisticsDTO) {
        // Check if at least one field is non-null in the MatchStatisticsDTO
        return matchStatisticsDTO.getAgentName() != null || matchStatisticsDTO.getAssists() != null ||
                matchStatisticsDTO.getUserName() != null || matchStatisticsDTO.getMatchID() != null ||
                matchStatisticsDTO.getKills() != null || matchStatisticsDTO.getDeaths() != null ||
                matchStatisticsDTO.getFirstKills() != null || matchStatisticsDTO.getFirstDeaths() != null ||
                matchStatisticsDTO.getUserScore() != null || matchStatisticsDTO.getOpponentScore() != null;
        // Return true if any field is non-null
    }

    // Delete entry for given entry id if it exists.
    @Override
    public void deleteMatchStatistics(Long entryId) {
        // Return type of findById is optional in case entry does not exist
        Optional<MatchStatisticsEntity> matchStatisticsEntityOptional = matchStatisticsRepository.findById(entryId);

        // Check if valid entry exists for given entryId
        if (matchStatisticsEntityOptional.isPresent()) {
            matchStatisticsRepository.deleteById(entryId);
        }
    }


}
