package com.gamedata.valorant.repository;

import com.gamedata.valorant.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
