package com.gamedata.valorant.converter;

import com.gamedata.valorant.dto.UserDTO;
import com.gamedata.valorant.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTO(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUserName(userDTO.getUserName());
        return userEntity;
    }

    public UserDTO convertEntity(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserName(userEntity.getUserName());
        return userDTO;
    }
}
