package com.example.medcheck.service.impl;

import com.example.medcheck.io.UserRepository;
import com.example.medcheck.io.entity.UserEntity;
import com.example.medcheck.service.UserService;
import com.example.medcheck.share.dto.UserDto;
import org.antlr.v4.runtime.misc.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    Utils utils;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity storedUserDetails = userRepository.findByEmail(userDto.getEmail());
        if(storedUserDetails != null) {
            throw new RuntimeException("Record already exist");
        }
        


        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");
        UserEntity storedUser = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser, returnValue);
        return returnValue;

    }


}

