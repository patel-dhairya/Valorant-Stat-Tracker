package com.gamedata.valorant.service;

import com.gamedata.valorant.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
