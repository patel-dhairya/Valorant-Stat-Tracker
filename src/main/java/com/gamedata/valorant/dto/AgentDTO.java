package com.gamedata.valorant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentDTO {
    private String userName;
    private int matchID;
    private String agentName;
    private int kills;
    private int deaths;
    private int assists;
    private int firstKills;
    private int firstDeaths;
}
