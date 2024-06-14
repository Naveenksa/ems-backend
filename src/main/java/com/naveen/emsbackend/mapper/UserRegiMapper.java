package com.naveen.emsbackend.mapper;

import com.naveen.emsbackend.dto.UserRegistrationDto;
import com.naveen.emsbackend.entity.UserRegistration;

public class UserRegiMapper {

    public static UserRegistration mapToUserRegi(UserRegistrationDto userRegistrationDto){
        return new UserRegistration(
          userRegistrationDto.getId(),
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getDob(),
                userRegistrationDto.getPhNumber(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getUserName(),
                userRegistrationDto.getPassword()
        );
    }
    public static UserRegistrationDto mapToUserRegiDto(UserRegistration userRegistration){
        return new UserRegistrationDto(
                userRegistration.getId(),
                userRegistration.getFirstName(),
                userRegistration.getLastName(),
                userRegistration.getDob(),
                userRegistration.getPhNumber(),
                userRegistration.getEmail(),
                userRegistration.getUserName(),
                userRegistration.getPassword()
        );
    }
}
