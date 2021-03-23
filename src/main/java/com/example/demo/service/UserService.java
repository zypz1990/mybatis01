package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张彦培
 * @date 2021/2/2517:15
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User getUserById(Integer id){
       return userMapper.getUserById(id);
    }
    public List<User> getUserList(){
        return userMapper.getUserList();
    }
}
