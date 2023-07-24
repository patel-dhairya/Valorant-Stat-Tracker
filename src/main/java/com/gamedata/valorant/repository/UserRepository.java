package com.gamedata.valorant.repository;

import com.gamedata.valorant.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserNameAndPassword(String userName, String password);
}
