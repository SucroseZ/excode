package com.example.ex6.mapper;

import com.example.ex6.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByNameAndGender(Map<String,String> map);

    int addUser(User user);
    int updateUserPassword(@Param("id")Integer id,@Param("password")String password);
    int deleteUser(Integer id);
}
