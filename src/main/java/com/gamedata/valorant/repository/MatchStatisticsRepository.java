package com.gamedata.valorant.repository;

import com.gamedata.valorant.entity.MatchStatisticsEntity;
import org.springframework.data.repository.CrudRepository;

public interface MatchStatisticsRepository extends CrudRepository<MatchStatisticsEntity, Long> {
}
