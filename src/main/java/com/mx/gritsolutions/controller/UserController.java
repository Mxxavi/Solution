package com.mx.gritsolutions.controller;

import com.mx.gritsolutions.entities.User;
import com.mx.gritsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam String mail) {
        return userService.createUser(name, mail);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserByID(@PathVariable Long id) {
        return userService.getById(id);
    }
}
