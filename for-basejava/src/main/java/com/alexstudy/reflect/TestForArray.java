package com.alexstudy.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName TestForArray
 * @Description TODO()
 * @date 2018/7/10 13:32:38
 */
public class TestForArray {
    public static void main(String[] args){
        List<Apple> objectList = new ArrayList<Apple>();

        for(int i = 0; i < 10; i++){
            Apple apple = new Apple();
            apple.setNumer("1");
            apple.setWord(""+i);
            objectList.add(apple);
        }
        for(Apple apple1: objectList){
            System.out.println(apple1.getNumer() + "   " + apple1.getWord());
        }
    }
}
