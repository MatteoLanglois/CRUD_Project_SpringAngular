package com.example.demo.controllers;

import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.LoginData;
import com.example.demo.models.Mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.Authenticator;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/{userId}")
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

    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(UserMapper.INSTANCE.toDTO(userService.create(user)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/users/{userId}")
    public UserDTO updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        user.setId(userId);
        return UserMapper.INSTANCE.toDTO(userService.update(user, userId));
    }

    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Integer userId) {
        userService.delete(userService.getById(userId));
        return ResponseEntity.noContent().build();
    }

@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginData loginData) {
    try {
        if (loginData.getUsername() == null || loginData.getPassword() == null) {
            throw new Exception("Please provide username and password");
        } else if (loginData.getPassword().equals(userService.getByUsername(loginData.getUsername()).getPassword())) {
            Integer loginId = userService.getByUsername(loginData.getUsername()).getId();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginId.toString());
        } else {
            throw new Exception("Invalid credentials");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
}