package com.reedsolutions.mybankapp.controller;

import com.reedsolutions.mybankapp.dto.BankResponseDto;
import com.reedsolutions.mybankapp.dto.UserRequestDto;
import com.reedsolutions.mybankapp.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public BankResponseDto createAccount(@RequestBody UserRequestDto userRequestDto){
        return userService.createAccount(userRequestDto);
    }
}
