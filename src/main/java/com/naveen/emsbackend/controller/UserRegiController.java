package com.naveen.emsbackend.controller;


import com.naveen.emsbackend.dto.UserRegistrationDto;
import com.naveen.emsbackend.entity.UserRegistration;
import com.naveen.emsbackend.service.UserRegiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserRegiController {

    @Autowired
    UserRegiService userRegiService;

    @PostMapping
    public  ResponseEntity<UserRegistrationDto> addUser(@RequestBody UserRegistrationDto  userRegistrationDto){
       UserRegistrationDto user= userRegiService.createUser(userRegistrationDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserRegistrationDto> findUser(@RequestBody Map<String,String> data){
UserRegistrationDto gotUser=userRegiService.getUserByUserAndPass(data.get("uName"), data.get("pass") );
return ResponseEntity.ok(gotUser);
    }
}
