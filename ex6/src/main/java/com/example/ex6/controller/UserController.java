package com.example.ex6.controller;

import com.example.ex6.entity.User;
import com.example.ex6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/user/nameAndGender")
    public List<User> findByNameAndGender(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String gender){
        Map<String,String> map = new HashMap<>();
        map.put("uname",name);
        map.put("ugender",gender);
        return userService.findByNameAndGender(map);
    }

    @PostMapping("/add")
    public int addStudent(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/user/update")
    public int updateUserPassword(@RequestParam(required = false) Integer id,
                             @RequestParam(required = false) String password){
        int count = userService.updateUserPassword(id, password);
        return count;
    }

    @DeleteMapping("/user/delete/{id}")
    public int deleteUser(@PathVariable Integer id){
        int count = userService.deleteUser(id);
        return count;
    }
}
