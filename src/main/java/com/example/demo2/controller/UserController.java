package com.example.demo2.controller;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;

    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser= userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/getById")
    public  ResponseEntity<User>getUserById(@PathVariable long id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails){
        return userService.updateUser(id,userDetails)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
