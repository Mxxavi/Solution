package com.mx.gritsolutions.service;

import com.mx.gritsolutions.entities.User;
import com.mx.gritsolutions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String mail){
        return userRepository.save(new User(name,mail));
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }


}
