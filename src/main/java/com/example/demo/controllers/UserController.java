package com.example.demo.controllers;

import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.Mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(UserMapper.INSTANCE.toDTO(userService.create(user)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/user/{userId}")
    public UserDTO updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        user.setId(userId);
        return UserMapper.INSTANCE.toDTO(userService.update(user));
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Integer userId) {
        userService.delete(userService.getById(userId));
        return ResponseEntity.noContent().build();
    }
}