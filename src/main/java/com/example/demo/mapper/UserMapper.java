package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张彦培
 * @date 2021/2/2517:16
 */
@Repository
public interface UserMapper {
    /**
     *@Description todo
     *@Param [java.lang.Integer]
     *@Return com.example.demo.entity.User
     *@Author zypz
     *@Date 17:20 2021/2/25
     */
    public User getUserById(Integer id);

    public List<User> getUserList();
}


























