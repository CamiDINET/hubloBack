package com.projet3.hublo.controller;

import com.projet3.hublo.entity.Category;
import com.projet3.hublo.entity.Product;
import com.projet3.hublo.entity.User;
import com.projet3.hublo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll(){ return userRepository.findAll(); }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){ return userRepository.findById(id).get(); }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setImmatriculation(user.getImmatriculation());
        userToUpdate.setMail(user.getMail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userToUpdate.setDefaultStation(user.getDefaultStation());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setPoste(user.getPoste());
        return userRepository.save(userToUpdate);
    }
    @DeleteMapping("users/{id}")
    public boolean deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
        return true;
    }
}
