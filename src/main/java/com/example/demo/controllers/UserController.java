package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.Mapper.UserMapper;
import com.example.demo.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{userId}")
    public UserDTO getUser(@PathVariable("userId") Integer userId) {
        return UserMapper.INSTANCE.toDTO(userService.getById(userId));
    }

    @GetMapping(value = "/users")
    public ArrayList<UserDTO> getAll() {
        List<User> users = userService.getAll();
        ArrayList<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(UserMapper.INSTANCE.toDTO(user));
        }
        return usersDTO;
    }

    @PostMapping(value = "/user")
    public UserDTO addUser(@RequestBody User user) {
        return UserMapper.INSTANCE.toDTO(userService.create(user));
    }


    @PostMapping(value = "/user/{userId}")
    public UserDTO updateUser(@PathVariable("userId") Integer userId) {
        return UserMapper.INSTANCE.toDTO(userService.getById(userId));
    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.delete(userService.getById(userId));
    }
}
