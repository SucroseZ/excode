package com.example.ex6.service;

import com.example.ex6.entity.User;
import com.example.ex6.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findByNameAndGender(Map<String,String> map){
        return userMapper.findByNameAndGender(map);
    }
    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    @Override
    public int updateUserPassword(Integer id,String password) {
        return userMapper.updateUserPassword(id, password);
    }
    @Override
    public int deleteUser(Integer id){
        return userMapper.deleteUser(id);
    }
}
