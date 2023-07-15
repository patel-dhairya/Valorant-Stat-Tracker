// This class will be converted to database table to store entries entered by users

package com.gamedata.valorant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ENTRY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class EntryEntity {
    // Generate auto increment id for each entry
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private int matchID;
    @Column(nullable = false)
    private String agentName;
    @Column(nullable = false)
    private int kills;
    @Column(nullable = false)
    private int deaths;
    @Column(nullable = false)
    private int assists;
    @Column(nullable = false)
    private int firstKills;
    @Column(nullable = false)
    private int firstDeaths;
}
