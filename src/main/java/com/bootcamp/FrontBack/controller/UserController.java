package com.bootcamp.FrontBack.controller;

import com.bootcamp.FrontBack.model.User;
import com.bootcamp.FrontBack.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/all/user")
    @ApiOperation(value = "Getting all the users")
    public List<User> userList() {
        return userService.userList();
    }



}
