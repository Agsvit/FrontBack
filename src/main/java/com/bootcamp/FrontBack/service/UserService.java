package com.bootcamp.FrontBack.service;

import com.bootcamp.FrontBack.model.User;
import com.bootcamp.FrontBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(
                () -> new UsernameNotFoundException("Not Found Username:" + userName));
        return user.get();
    }

    public List<User> userList() {
        return userRepository.findAll();
    }
}
