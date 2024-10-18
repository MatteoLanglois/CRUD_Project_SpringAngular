package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.Mapper.UserMapper;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(value = "/user/{userId}")
    public UserDTO getUser(@PathVariable("userId") Integer userId) {
        return new UserDTO();
    }

    @GetMapping(value = "/users")
    public ArrayList<UserDTO> getAll() {
        ArrayList<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO());
        users.add(new UserDTO());
        users.add(new UserDTO());
        users.add(new UserDTO());
        users.add(new UserDTO());

        return users;
    }

    @PostMapping(value = "/user")
    public UserDTO addUser(@RequestBody User user) {
        return UserMapper.INSTANCE.toDTO(user);
    }


    @PostMapping(value = "/user/{userId}")
    public UserDTO updateUser(@PathVariable("userId") Integer userId) {
        return new UserDTO();
    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
    }
}
