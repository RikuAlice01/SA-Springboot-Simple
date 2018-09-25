package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.entity.User;
import com.sut.sa.cpe.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/VIP")
    public Collection<User> VIP() {
        return userRepository.findAll().stream().filter(this::VIP).collect(Collectors.toList());
    }

    private boolean VIP(User user) {
        return user.getUsername().equals("Sitthichai") || user.getUsername().equals("Tanapon");
    }

    // curl -iX POST -H 'Content-Type: application/json' -d {"username": "johnny"}
    // http://localhost:8080/Regit
    // @PostMapping("/Regit")
    // public User newUser(@Valid @RequestBody User newUser){
    // return userRepository.save(newUser); // บันทึก Objcet ชื่อ user
    // }

    // ทดสอบโดย ใช้คำสั่ง curl -X POST localhost:8080/Regit/nanti
    @PutMapping("/Regit/{userName}")
    public User newUser(@PathVariable String userName) {
        User newUser = new User();
        newUser.setUsername(userName);
        return userRepository.save(newUser); // บันทึก Objcet ชื่อ user
    }

    @GetMapping("/Users")
    public Collection<User> User() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

}