// This class will be converted to database table to store entries entered by users

package com.gamedata.valorant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MATCH_STATISTICS_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class MatchStatisticsEntity {
    // Generate auto increment id for each entry
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String matchID;
    @Column(nullable = false)
    private String agentName;
    @Column(nullable = false)
    private String kills;
    @Column(nullable = false)
    private String deaths;
    @Column(nullable = false)
    private String assists;
    @Column(nullable = false)
    private String firstKills;
    @Column(nullable = false)
    private String firstDeaths;
    @Column(nullable = false)
    private String userScore;
    @Column(nullable = false)
    private String opponentScore;

}
