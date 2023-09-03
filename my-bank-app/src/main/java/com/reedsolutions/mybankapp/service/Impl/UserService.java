package com.reedsolutions.mybankapp.service.Impl;

import com.reedsolutions.mybankapp.dto.BankResponseDto;
import com.reedsolutions.mybankapp.dto.UserRequestDto;

public interface UserService {
   BankResponseDto createAccount(UserRequestDto userRequestDto);

}
