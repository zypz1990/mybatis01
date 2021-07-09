package com.example.demo;

import com.example.demo.entity.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 张彦培
 * @date 2021/4/420:54
 */
public class MyInvocation implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        method.invoke(null, args);
        System.out.println("--------ppppp------------");
        return new User(2, "jjj", "mmm", "9999");
    }
}
