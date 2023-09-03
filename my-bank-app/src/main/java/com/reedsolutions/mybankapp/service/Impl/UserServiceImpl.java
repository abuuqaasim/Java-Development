package com.reedsolutions.mybankapp.service.Impl;

import com.reedsolutions.mybankapp.dto.AccountInfo;
import com.reedsolutions.mybankapp.dto.BankResponseDto;
import com.reedsolutions.mybankapp.dto.UserRequestDto;
import com.reedsolutions.mybankapp.entity.User;
import com.reedsolutions.mybankapp.repository.UserRepository;
import com.reedsolutions.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
public BankResponseDto createAccount(UserRequestDto userRequestDto){
    /*
      creating an account - saving a new user into the db
      check if user already has an account
      */

    if (userRepository.existsByEmail(userRequestDto.getEmail())){
        return BankResponseDto.builder()
                .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                .accountInfo(null).build();

    }
    User newUser = User.builder()
            .firstName(userRequestDto.getFirstName())
            .lastName(userRequestDto.getLastName())
            .otherName(userRequestDto.getOtherName())
            .gender(userRequestDto.getGender())
            .stateOfOrigin(userRequestDto.getStateOfOrigin())
            .address(userRequestDto.getAddress())
            .accountNumber(AccountUtils.GenerateAccountNumber())
            .email(userRequestDto.getEmail())
            .accountBalance(BigDecimal.ZERO)
            .phoneNumber(userRequestDto.getPhoneNumber())
            .alternativePhoneNumber(userRequestDto.getAlternativePhoneNumber())
            .status("ACTIVE")
            .build();

    User savedUser = userRepository.save(newUser);

    return  BankResponseDto.builder()
            .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
            .responseMessage(AccountUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
            .accountInfo(AccountInfo.builder()
                    .accountBalance(savedUser.getAccountBalance())
                    .accountNumber(savedUser.getAccountNumber())
                    .accountName(savedUser.getFirstName() + "   "+savedUser.getLastName() +" "+savedUser.getOtherName())
                            .build())
                    .build();
}


}
