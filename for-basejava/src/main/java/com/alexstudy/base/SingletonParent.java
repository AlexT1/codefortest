package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName SingletonParent
 * @Description TODO()
 * @date 2018/7/25 14:11:57
 */
public class SingletonParent {
    private static final SingletonParent INSTANCE = new SingletonParent();
    private SingletonParent(){

    }
    public static SingletonParent getInstance(){
        return INSTANCE;
    }
}
