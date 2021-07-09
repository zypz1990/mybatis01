package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.interfaces.UserInterface;

import java.lang.reflect.Proxy;

/**
 * @author 张彦培
 * @date 2021/4/420:54
 */
public class ProxyMain {
    private static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
//        System.out.println( getMapper());
//        System.out.println(13&3);
        int i = 0;
        for (; ; ) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            i++;
            Runnable target;
            Thread thread0 = new Thread(() -> {
                a = 1;
                x = b;

            });
            Thread thread1 = new Thread(() -> {
                b = 1;
                y = a;

            });
            thread0.start();
            thread1.start();
            thread0.join();
            thread1.join();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次发生重排序");

                break;
            } else {
                System.out.println("没有发生指令重排序：" + i);
            }
        }


    }

    public static User getMapper() {
        UserInterface o = (UserInterface) Proxy.newProxyInstance(UserInterface.class.getClassLoader(), new Class[]{UserInterface.class}, new MyInvocation());
        return o.getUser();
    }

}
