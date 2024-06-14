package com.naveen.emsbackend.service.impl;

import com.naveen.emsbackend.dto.UserRegistrationDto;
import com.naveen.emsbackend.entity.UserRegistration;
import com.naveen.emsbackend.mapper.UserRegiMapper;
import com.naveen.emsbackend.repository.UserRegiRepos;
import com.naveen.emsbackend.service.UserRegiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class UserRegiServiceImpl implements UserRegiService {

    @Autowired
    private UserRegiRepos userRegiRepos;

    @Override
    public UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto) {
        UserRegistration userRegistration= UserRegiMapper.mapToUserRegi(userRegistrationDto);
        UserRegistration savedUserRegi= userRegiRepos.save(userRegistration);
        return UserRegiMapper.mapToUserRegiDto(savedUserRegi);
    }

    @Override
    public UserRegistrationDto getUserByUserAndPass(String uname,String pass) {
        UserRegistration user= userRegiRepos.findByuserNameAndPassword(uname,pass);
        return UserRegiMapper.mapToUserRegiDto(user);
    }
}
