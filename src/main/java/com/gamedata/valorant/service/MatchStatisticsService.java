// This code structure follows layered architecture. It receives request from Controller and will perform
// necessary business logic.
// Follows Factory design pattern for implementation
// Help with case of  multiple implementation class of same interface

package com.gamedata.valorant.service;

import com.gamedata.valorant.dto.MatchStatisticsDTO;

import java.util.List;

public interface MatchStatisticsService {
    MatchStatisticsDTO saveMatchStatistics(MatchStatisticsDTO matchStatisticsDTO);

    // Return all the saved entries
    List<MatchStatisticsDTO> getAllStatistics();

    // Update any single entry in case wrong data was given
    MatchStatisticsDTO updateMatchStatistics(MatchStatisticsDTO newMatchStatisticsDTO, Long entryID);
}
