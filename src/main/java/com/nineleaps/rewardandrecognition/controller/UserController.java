package com.nineleaps.rewardandrecognition.controller;
import com.nineleaps.rewardandrecognition.dto.UserDto;
import com.nineleaps.rewardandrecognition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
}
