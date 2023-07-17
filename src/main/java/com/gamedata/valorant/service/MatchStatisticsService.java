// This code structure follows layered architecture. It receives request from Controller and will perform
// necessary business logic.
// Follows Factory design pattern for implementation
// Help with case of  multiple implementation class of same interface

package com.gamedata.valorant.service;

import com.gamedata.valorant.dto.MatchStatisticsDTO;

public interface MatchStatisticsService {
    public MatchStatisticsDTO saveMatchStatistics(MatchStatisticsDTO matchStatisticsDTO);
}
