package com.gamedata.valorant.repository;

import com.gamedata.valorant.entity.EntryEntity;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<EntryEntity, Long> {
}
