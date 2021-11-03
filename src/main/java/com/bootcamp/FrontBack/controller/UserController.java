package com.bootcamp.FrontBack.controller;

import com.bootcamp.FrontBack.controller.request.UserRequest;
import com.bootcamp.FrontBack.controller.response.UserResponse;
import com.bootcamp.FrontBack.model.User;
import com.bootcamp.FrontBack.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/all/user")
    @ApiOperation(value = "Getting all the users",
            authorizations = { @Authorization(value="basicAuth") })
    public List<User> userList() {
        return userService.userList();
    }

    @PostMapping(value = "/post/create/user")
    @ApiOperation(value = "Creating a new user",
            authorizations = { @Authorization(value="basicAuth") })
    public User createUser(@RequestBody UserRequest request) {
        User user = User.builder()
                .userName(request.getUserName())
                .age(request.getAge())
                .password(request.getPassword())
                .build();
        userService.createUser(user);
        return user;
    }

    @PutMapping(value = "/put-edit-user/{id}")
    @ApiOperation(value = "Modifying a new user",
            authorizations = { @Authorization(value="basicAuth") })
    public ResponseEntity editUser(@PathVariable Long id, @RequestBody UserResponse userResponse) {
        return ResponseEntity.created(URI.create("/user/" + id + "/name")).body("User updated ");
    }






}
