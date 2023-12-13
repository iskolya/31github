package com.example.medcheck.service;

import com.example.medcheck.share.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDetails loadUserByUserName(String username) throws UsernameNotFoundException;
}

