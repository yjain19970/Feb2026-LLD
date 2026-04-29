package com.example.scaler.bmsapril26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.scaler.bmsapril26.dto.UserDTO;
import com.example.scaler.bmsapril26.exception.BadRequestException;
import com.example.scaler.bmsapril26.model.User;
import com.example.scaler.bmsapril26.service.interfaces.UserService;
import com.example.scaler.bmsapril26.translator.UserTranslator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    public UserDTO signUp(UserDTO requestDTO) throws BadRequestException{
        if(invalidRequest(requestDTO)){
            throw new BadRequestException("Request is invalid!");
        }
        User createdUser = null;
        try{
            createdUser =  userService.createUser(requestDTO.getUserName(), requestDTO.getPassword());
        } catch(Exception e){
            System.out.println("Exception happened: " + e.getStackTrace());
            throw new InternalError();
        }
        return UserTranslator.translate(createdUser);
    }

    private boolean invalidRequest(UserDTO requestDTO) {
        return false;
    }
}
