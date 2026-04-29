package com.example.scaler.bmsapril26.translator;

import com.example.scaler.bmsapril26.dto.UserDTO;
import com.example.scaler.bmsapril26.model.User;

public class UserTranslator {

    public static UserDTO translate(User createdUser) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(createdUser.getUname());
        userDTO.setId(createdUser.getId());
        return userDTO;
    }
    
}
