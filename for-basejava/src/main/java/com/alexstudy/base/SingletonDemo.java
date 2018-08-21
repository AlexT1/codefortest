package com.alexstudy.base;

import javax.inject.Singleton;
import java.util.Collections;

/**
 * @author AlexTong
 * @ClassName SingletonDemo
 * @Description TODO()
 * @date 2018/7/25 14:11:29
 */
public class SingletonDemo<T> {
//    private static T instance = null;
//    public static T getInstance() {
//        if (instance == null)
//            instance = new SingletonDemo<T>();
//        return instance;
//    }
//static field is can not use generic type, because of type must be confirmed when is static

    private T instance = null;
    public  T getInstance() {
        if (instance == null)
            instance = (T) new SingletonDemo<T>();
        return instance;
    }


}
