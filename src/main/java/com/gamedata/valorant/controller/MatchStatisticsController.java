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
        return new ResponseEntity<>(matchStatisticsDTO, HttpStatus.CREATED);
    }

    @GetMapping("/stat")
    public ResponseEntity<List<MatchStatisticsDTO>> getAllStatistics(){
        List<MatchStatisticsDTO> matchStatisticsList = matchStatisticsService.getAllStatistics();
        return new ResponseEntity<>(matchStatisticsList, HttpStatus.OK);
    }

    @PutMapping("/stat/{entryId}")
    public ResponseEntity<MatchStatisticsDTO> updateMatchStatistics(@RequestBody MatchStatisticsDTO matchStatisticsDTO, @PathVariable Long entryId){
        matchStatisticsDTO = matchStatisticsService.updateMatchStatistics(matchStatisticsDTO, entryId);
        // Entry not found
        if (matchStatisticsDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(matchStatisticsDTO, HttpStatus.CREATED);
    }

    // This endpoint is used when one does not need to update entire entry and only wants update required values
    @PatchMapping("/stat/{entryId}")
    public ResponseEntity<MatchStatisticsDTO> partialUpdateMatchStatistics(@RequestBody MatchStatisticsDTO matchStatisticsDTO, @PathVariable Long entryId){
        matchStatisticsDTO = matchStatisticsService.partialUpdateMatchStatistics(matchStatisticsDTO, entryId);
        // Entry not found
        if (matchStatisticsDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(matchStatisticsDTO, HttpStatus.OK);
    }

    // This endpoint is used when user wants to delete existing entry by providing associated entryId.
    // It assumes that entryId is correct and it exists
    @DeleteMapping("/stat/{entryId}")
    public ResponseEntity deleteMatchStatistics(@PathVariable Long entryId){
        matchStatisticsService.deleteMatchStatistics(entryId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

}
