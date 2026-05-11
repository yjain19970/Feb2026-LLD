package com.example.scaler.bms.may2026.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.scaler.bms.may2026.exception.InvalidRequestException;
import com.example.scaler.bms.may2026.model.User;
import com.example.scaler.bms.may2026.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerUser(String userEmail, String password) throws InvalidRequestException {
        List<User> allUsers =  userRepository.findAll();
        log.info("allUsers: " + allUsers.size());
        
        for(User user: allUsers){
            if(!user.getEmail().equals(userEmail)){
                throw new InvalidRequestException("UserEmail is already registered!");
            }
        }
        User userToBeSaved = new User();
        String encodedPassword =  passwordEncoder.encode(password);

        userToBeSaved.setCreatedAt(new Date());
        userToBeSaved.setDeleted(false);
        userToBeSaved.setEmail(userEmail);
        userToBeSaved.setPassword(encodedPassword);
        User userCreated =  userRepository.save(userToBeSaved);
        return userCreated;
    }


    public boolean login(String userEmail, String password) throws InvalidRequestException{
        List<User> allUsers =  userRepository.findAll();
        
        for(User user: allUsers){
            if(user.getEmail().equals(userEmail)){
                if(passwordEncoder.matches(password, user.getPassword())){
                    log.info("User is loggedin!");
                    return true;
                }
            }
        }
        return false;
    }
    
}
