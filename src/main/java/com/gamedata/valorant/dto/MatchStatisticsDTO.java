package com.gamedata.valorant.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The MatchStatisticsDTO class represents the match statistics entry for a player in the FPS game Valorant.
 * It serves as a Data Transfer Object (DTO) used to transfer match statistics data between different layers or systems.
 */
@Getter
@Setter
public class MatchStatisticsDTO {

    private Long id;

    // Username of the player
    private String userName;

    // Match ID of the match played by the player
    private String matchID;

    // Agent picked by the player for that matchID
    private String agentName;

    // Number of kills achieved by the player
    private String kills;

    // Number of times the player died
    private String deaths;

    // Number of assists achieved by the player
    private String assists;

    // Number of first kills achieved by the player
    private String firstKills;

    // Number of times the player died first in a round
    private String firstDeaths;

    // Scores of that match. Look at MatchScore class for more information
    private String userScore;
    private String opponentScore;
}
