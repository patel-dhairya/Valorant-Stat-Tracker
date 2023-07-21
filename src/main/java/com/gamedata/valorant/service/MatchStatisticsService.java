// This code structure follows layered architecture. It receives request from Controller and will perform
// necessary business logic.
// Follows Factory design pattern for implementation
// Help with case of  multiple implementation class of same interface

package com.gamedata.valorant.service;

import com.gamedata.valorant.dto.MatchStatisticsDTO;

import java.util.List;

public interface MatchStatisticsService {
    // Save the given MatchStatisticsDTO object to the database
    MatchStatisticsDTO saveMatchStatistics(MatchStatisticsDTO matchStatisticsDTO);

    // Return all the saved entries in the database
    List<MatchStatisticsDTO> getAllStatistics();

    // Update all fields of a specific entry identified by the given entryID
    // Use this method when you want to completely replace the existing data with new data
    MatchStatisticsDTO updateMatchStatistics(MatchStatisticsDTO newMatchStatisticsDTO, Long entryID);

    // Update specific fields of a specific entry identified by the given entryID
    // Use this method when you want to update only certain fields of the existing data
    // The fields that are present in the matchStatisticsDTO parameter will be updated,
    // and the fields that are not present will remain unchanged.
    MatchStatisticsDTO partialUpdateMatchStatistics(MatchStatisticsDTO matchStatisticsDTO, Long entryId);
}
