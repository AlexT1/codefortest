package com.alexstudy.base;

import java.io.ObjectStreamException;

/**
 * @author AlexTong
 * @ClassName SingletonModeTest
 * @Description TODO()
 * @date 2018/7/17 9:49:29
 */
//first type : Singleton with final field, if you confirm in global field is has and only has one, mean always singleton, use this
//public class SingletonModeTest {
//    public static final SingletonModeTest INSTANCE = new SingletonModeTest();
//
//    private SingletonModeTest(){
//
//    }
//    //Remainder omitted
//}

//second type : Singleton with static factory, if none of above and you want to have some flexibility, use this
public class SingletonModeTest {
    public static final SingletonModeTest INSTANCE = new SingletonModeTest();

    private SingletonModeTest(){

    }
    public static SingletonModeTest getInstance(){
        return INSTANCE;
    }
    //Remainder omitted

    //readResolve method to preserve singleton property
    private Object readResolve() throws ObjectStreamException {
        /*
         * Return the one true Elvis and let the garbage collector take care of the SingletonModeTest impersonator.
         */
        return INSTANCE;
    }
}