package com.example.scaler.bms.may2026.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.scaler.bms.may2026.dto.ErrorDTO;
import com.example.scaler.bms.may2026.dto.UserRequestDTO;
import com.example.scaler.bms.may2026.exception.InvalidRequestException;
import com.example.scaler.bms.may2026.model.User;
import com.example.scaler.bms.may2026.service.UserServiceImpl;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    

    
    @PostMapping("/user")
    public ResponseEntity<UserRequestDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserRequestDTO response = new UserRequestDTO();

        User createdUser;
        try {
            createdUser = userServiceImpl.registerUser(userRequestDTO.getUserEmail(), userRequestDTO.getPassword());
        } catch (InvalidRequestException e) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setErrorCode("ERROR_CODE_101");
            errorDTO.setErrorMsg("User is already registered.");
            response.setErrorDTO(errorDTO);
            return ResponseEntity.ok(response);
        }
        
        response.setPassword(createdUser.getPassword());
        response.setUserEmail(createdUser.getEmail());
        response.setUserId(createdUser.getId());
        return ResponseEntity.ok(response);
    }


    @PostMapping("/user/login")
    public boolean loginUser(@RequestBody UserRequestDTO userRequestDTO) throws InvalidRequestException{
        return userServiceImpl.login(userRequestDTO.getUserEmail(), userRequestDTO.getPassword());
    }
}
