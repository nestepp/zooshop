package com.example.petshop.service;

import com.example.petshop.model.User;
import com.example.petshop.web.dto.UserRegistrarionDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrarionDto userRegistrarionDto);
}
