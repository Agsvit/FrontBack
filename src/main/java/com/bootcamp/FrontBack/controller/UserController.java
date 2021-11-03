package com.bootcamp.FrontBack.controller;

import com.bootcamp.FrontBack.controller.request.UpdateUserRequest;
import com.bootcamp.FrontBack.controller.request.UserRequest;
import com.bootcamp.FrontBack.controller.response.UserResponse;
import com.bootcamp.FrontBack.controller.response.UserVerifyResponse;
import com.bootcamp.FrontBack.exception.UpdateUserException;
import com.bootcamp.FrontBack.model.User;
import com.bootcamp.FrontBack.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/all/user")
    @ApiOperation(value = "Getting all the users",
            authorizations = {@Authorization(value = "basicAuth")})
    public List<UserResponse> userList() {
        List<User> userList = userService.userList();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : userList) {
            userResponseList.add(UserResponse.builder()
                    .id(user.getId())
                    .name(user.getUsername())
                    .password(user.getPassword())
                    .age(user.getAge())
                    .build());
        }
        return userResponseList;
    }

    @PostMapping(value = "/users/name-password")
    @ApiOperation(value = "Verifies user and password",
            authorizations = {@Authorization(value = "basicAuth")})
    public UserVerifyResponse verifyUser(@RequestBody UserRequest userRequest) {
        User user = userService.verifyUser(userRequest.getUserName(), userRequest.getPassword());
        return UserVerifyResponse.builder()
                .id(user.getId())
                .build();
    }

    @PostMapping(value = "/post/create/user")
    @ApiOperation(value = "Creating a new user",
            authorizations = {@Authorization(value = "basicAuth")})
    public UserResponse createUser(@RequestBody UpdateUserRequest request) {
        User user = User.builder()
                .userName(request.getUserName())
                .age(request.getAge())
                .password(request.getPassword())
                .build();
        userService.createUser(user);
        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .name(user.getUsername())
                .password(user.getPassword())
                .age(user.getAge())
                .build();
        return userResponse;
    }

    @PutMapping(value = "/put-edit-user/{id}")
    @ApiOperation(value = "Modifying a new user",
            authorizations = {@Authorization(value = "basicAuth")})
    public ResponseEntity updateUserById(@PathVariable Long id, @RequestBody UpdateUserRequest request) throws UpdateUserException {
        final User updateUserById = userService.updateUser(id, request);
        return ResponseEntity.created(URI.create("/user" + id + "name")).body("Updated user");
    }

    @ExceptionHandler(UpdateUserException.class)
    public ResponseEntity<String> updateUser(UpdateUserException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


}
