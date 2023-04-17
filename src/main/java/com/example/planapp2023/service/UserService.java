package com.example.planapp2023.service;

import com.example.planapp2023.domain.serviceModel.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
