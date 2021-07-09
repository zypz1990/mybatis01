package com.example.demo.comtroller;

import com.example.demo.service.MyCacheService;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author 张彦培
 * @date 2021/7/315:43
 */
public class DemoClazz implements Serializable {
    private static final long serialVersionUID = 42L;
    private final static DemoClazz clazz=new DemoClazz();
//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
////        DemoClazz demoClazz = new DemoClazz();
////        System.out.println("yyy");
////        Constructor<DemoClazz> declaredConstructor = DemoClazz.class.getDeclaredConstructor();
////        declaredConstructor.setAccessible(true);
////        DemoClazz demoClazz1 = declaredConstructor.newInstance();
////        System.out.println(demoClazz1==demoClazz);
//        DemoSingleton instance = DemoSingleton.INSTANCE;
//        DemoSingleton instance1 = DemoSingleton.INSTANCE;
//        System.out.println(instance==instance1);
//
//    }
public static void main(String[] args) {
    MyCacheService myCacheService=new MyCacheService();
    myCacheService.getUserById(7);
}
    private DemoClazz(){
        if(null!=clazz){
            throw new RuntimeException("实例不能创建多个");
        }
    }
    public static DemoClazz getInstance(){
        return clazz;
    }
    private Object readResolve() throws ObjectStreamException{
        return getInstance();
    }
}
