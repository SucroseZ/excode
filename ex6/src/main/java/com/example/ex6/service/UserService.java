package com.example.ex6.service;

import com.example.ex6.entity.User;
import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByNameAndGender(Map<String,String> map);
    int addUser(User user);
    int updateUserPassword(Integer id,String password);
    int deleteUser(Integer id);
}
