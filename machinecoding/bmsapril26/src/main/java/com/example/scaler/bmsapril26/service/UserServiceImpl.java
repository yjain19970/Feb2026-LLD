package com.example.scaler.bmsapril26.service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.scaler.bmsapril26.exception.InvalidPasswordException;
import com.example.scaler.bmsapril26.model.User;
import com.example.scaler.bmsapril26.repository.UserRepository;
import com.example.scaler.bmsapril26.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(String userName, String password) {
        User user = new User();
        String encodedPwd = passwordEncoder.encode(password);
        user.setPwd(encodedPwd);
        user.setUname(userName);

        User createdUser =  userRepository.save(user);
        return createdUser;
    }

    @Override
    public boolean login(String uName, String password) throws InvalidPasswordException {
        Optional<User> userOptional =  userRepository.findByUname(uName);
        if(!userOptional.isPresent()){
            // throw an exception from here.
        }
        User userDetail = userOptional.get();
        if(passwordEncoder.matches(password, userDetail.getPwd())){
            System.out.println("Login success!");
        }else{
            System.out.println("Invalid password!");
            throw new InvalidPasswordException("Password is Invalid");
        }

        return true;
    }
    
}
