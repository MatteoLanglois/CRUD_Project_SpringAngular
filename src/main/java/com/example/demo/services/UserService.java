package com.example.demo.services;

import com.example.demo.exceptions.user.UserNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public User create(User user) {
      return userRepository.save(user);
    }

    @Transactional
    public User update(User user, int id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setNom(user.getNom());
            existingUser.setPrenom(user.getPrenom());
            existingUser.setMail(user.getMail());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
}
