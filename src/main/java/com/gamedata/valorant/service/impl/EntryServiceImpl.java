package com.gamedata.valorant.service.impl;

import com.gamedata.valorant.dto.EntryDTO;
import com.gamedata.valorant.service.EntryService;
import org.springframework.stereotype.Service;


// Make EntryServiceImpl class singleton instance to make it more memory efficient
@Service
public class EntryServiceImpl implements EntryService {

    @Override
    public EntryDTO saveEntry(EntryDTO entryDTO) {
        return null;
    }
}
