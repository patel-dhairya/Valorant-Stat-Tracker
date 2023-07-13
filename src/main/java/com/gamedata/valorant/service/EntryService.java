// Follows Factory design pattern for implementation
// Help with case of  multiple implementation class of same interface

package com.gamedata.valorant.service;

import com.gamedata.valorant.dto.EntryDTO;

public interface EntryService {
    public EntryDTO saveEntry(EntryDTO entryDTO);
}