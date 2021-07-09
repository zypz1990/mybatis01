package com.example.demo.comtroller;

import java.io.*;

/**
 * @author 张彦培
 * @date 2021/7/317:12
 */
public class DemoSerializable{
    public static void main(String[] args) {
        DemoClazz instance = DemoClazz.getInstance();
//        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("testSerializable"))){
//            oos.writeObject(instance);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        DemoClazz instance1=null;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("testSerializable"))) {
            instance1 = (DemoClazz)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(instance==instance1);

    }
}
