package com.example.scaler.bmsapril26.service.interfaces;

import com.example.scaler.bmsapril26.exception.InvalidPasswordException;
import com.example.scaler.bmsapril26.model.User;

public interface UserService {
    public User createUser(String userName, String password);

    public boolean login(String uName, String password) throws InvalidPasswordException;
}
