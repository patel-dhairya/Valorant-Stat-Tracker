// This code structure follows layered architecture. Controller layer will take request from client and pass it to service

package com.gamedata.valorant.controller;

import com.gamedata.valorant.dto.MatchStatisticsDTO;
import com.gamedata.valorant.service.MatchStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/stat")
    public ResponseEntity<List<MatchStatisticsDTO>> getAllStatistics(){
        List<MatchStatisticsDTO> matchStatisticsList = matchStatisticsService.getAllStatistics();
        ResponseEntity<List<MatchStatisticsDTO>> responseEntity = new ResponseEntity<>(matchStatisticsList, HttpStatus.OK);
        return responseEntity;
    }

}
