package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.entity.User;
import com.sut.sa.cpe.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class UserController {
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/VIP")
    public Collection<User> VIP() {
        return repository.findAll().stream()
                .filter(this::VIP)
                .collect(Collectors.toList());
    }

    @GetMapping("/Users")
    public Collection<User> User() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }


    private boolean VIP(User user) {
        return user.getName().equals("Sitthichai") ||
                user.getName().equals("Tanapon");
    }
}