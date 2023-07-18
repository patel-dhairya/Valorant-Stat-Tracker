// This code structure follows layered architecture. Controller layer will take request from client and pass it to service

package com.gamedata.valorant.controller;

import com.gamedata.valorant.dto.MatchStatisticsDTO;
import com.gamedata.valorant.service.MatchStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MatchStatisticsController {

    // Let the spring handle dependency injection and pass the data to entryService
    @Autowired
    private MatchStatisticsService matchStatisticsService;
    //
    @PostMapping("/stat")
    public ResponseEntity<MatchStatisticsDTO> saveAgentStat(@RequestBody MatchStatisticsDTO matchStatisticsDTO){
        matchStatisticsDTO = matchStatisticsService.saveMatchStatistics(matchStatisticsDTO);
        ResponseEntity<MatchStatisticsDTO> responseEntity = new ResponseEntity<>(matchStatisticsDTO, HttpStatus.CREATED);
        return responseEntity;
    }

}
