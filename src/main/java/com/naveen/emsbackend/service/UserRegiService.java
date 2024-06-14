package com.naveen.emsbackend.service;

import com.naveen.emsbackend.dto.UserRegistrationDto;

import java.util.Map;

public interface UserRegiService {

    UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto);
UserRegistrationDto getUserByUserAndPass(String uname,String pass);
}
