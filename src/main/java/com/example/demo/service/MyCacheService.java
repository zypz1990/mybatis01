package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author 张彦培
 * @date 2021/7/816:57
 */
@Service
public class MyCacheService {
    @Cacheable(value = "zyp:myCache:user",key="#id")
    public User getUserById(int id){
        System.out.println("-------------缓存");
        return new User(id,"zyp","张彦培");
    }
}
