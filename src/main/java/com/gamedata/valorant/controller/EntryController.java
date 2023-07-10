package com.gamedata.valorant.controller;

import com.gamedata.valorant.dto.EntryDTO;
import com.gamedata.valorant.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EntryController {

    // Let the spring handle dependency injection
    @Autowired
    private EntryService entryService;
    //
    @PostMapping("/stat")
    public EntryDTO saveAgentStat(@RequestBody EntryDTO entryDTO){
        entryService.saveEntry(entryDTO);
        System.out.println(entryDTO);
        return entryDTO;
    }

}
