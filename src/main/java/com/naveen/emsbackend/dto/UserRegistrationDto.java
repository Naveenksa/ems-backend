package com.naveen.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

    private long Id;
    private String firstName;
    private String lastName;
    private String dob;
    private long phNumber;
    private String email;
    private String userName;
    private String password;
}
