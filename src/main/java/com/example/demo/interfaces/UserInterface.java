package com.example.demo.interfaces;

import com.example.demo.entity.User;

/**
 * @author 张彦培
 * @date 2021/4/420:57
 */
public interface UserInterface {
    public User getUser();
    public User getUserById(int id);
}
