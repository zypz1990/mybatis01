package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 张彦培
 * @date 2021/2/2517:09
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 42L;
    private int id;
    private String userName;

    public User(int id) {
        this.id = id;
    }

    private String realName;
    private String password;

    public User(int id, String userName, String realName) {
        this.id = id;
        this.userName = userName;
        this.realName = realName;
    }

    public User() {
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str = null;
        sb.append(str);
        System.out.println(sb.length());
    }
}
