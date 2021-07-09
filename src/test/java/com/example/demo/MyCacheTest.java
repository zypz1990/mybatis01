package com.example.demo;

import com.example.demo.service.MyCacheService;
import org.junit.Test;

/**
 * @author 张彦培
 * @date 2021/7/817:00
 */
public class MyCacheTest {

    public static void main(String[] args) {
        MyCacheService myCacheService=new MyCacheService();
        myCacheService.getUserById(7);
    }
    @Test
    void testMyCache(){
        MyCacheService myCacheService=new MyCacheService();
        myCacheService.getUserById(7);
    }
}
