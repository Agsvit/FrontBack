package com.bootcamp.FrontBack.service;

import com.bootcamp.FrontBack.controller.request.UpdateUserRequest;
import com.bootcamp.FrontBack.exception.InvalidPassword;
import com.bootcamp.FrontBack.exception.UpdateUserException;
import com.bootcamp.FrontBack.exception.UserNotFound;
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

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, UpdateUserRequest request)  {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UpdateUserException("User not found"));
        user.setUserName(request.getUserName());
        user.setAge(request.getAge());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return user;
    }

    public User verifyUser(String userName, String password) {
        User user = userRepository.findByUserName(userName).orElseThrow(UserNotFound::new);
        if (user.getPassword().equals(password)) {
            return user;
        }
        else {
            throw new InvalidPassword();
        }
    }
}

