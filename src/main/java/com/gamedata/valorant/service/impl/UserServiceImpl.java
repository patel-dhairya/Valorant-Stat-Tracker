package com.gamedata.valorant.service.impl;

import com.gamedata.valorant.converter.UserConverter;
import com.gamedata.valorant.dto.UserDTO;
import com.gamedata.valorant.entity.UserEntity;
import com.gamedata.valorant.repository.UserRepository;
import com.gamedata.valorant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;
    // Handles registration of a new user
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTO(userDTO);
        userRepository.save(userEntity);
        return userConverter.convertEntity(userEntity);
    }

    // Handles login for existing user
    @Override
    public UserDTO login(String userName, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserNameAndPassword(userName, password);
        // Username and Password are correct and match in database
        if (optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntity(optionalUserEntity.get());
        }
        return userDTO;
    }
}
