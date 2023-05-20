package com.example.petshop.service;

import com.example.petshop.model.Role;
import com.example.petshop.model.User;
import com.example.petshop.repository.UserRepository;
import com.example.petshop.web.dto.UserRegistrarionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrarionDto userRegistrarionDto) {
        User user;
        if (userRegistrarionDto.getEmail().equals("admin") && userRegistrarionDto.getPassword().equals("admin")) {
            user = new User(userRegistrarionDto.getFirstName(), userRegistrarionDto.getLastName(),
                    userRegistrarionDto.getEmail(), userRegistrarionDto.getNumber(), passwordEncoder.encode(userRegistrarionDto.getPassword()),
                    Arrays.asList(new Role("ROLE_ADMIN")));
        }
        else {
            user = new User(userRegistrarionDto.getFirstName(), userRegistrarionDto.getLastName(),
                    userRegistrarionDto.getEmail(), userRegistrarionDto.getNumber(), passwordEncoder.encode(userRegistrarionDto.getPassword()),
                    Arrays.asList(new Role("ROLE_USER")));
        }
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
