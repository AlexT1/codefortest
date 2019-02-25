package com.alexstudy.base;

/**
 * @ClassName Mustang
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/28
 */
public class Mustang extends Horse implements Mammal {
    public static void main(String... args) {
        Mustang myApp = new Mustang();
        System.out.println(myApp.identifyMyself());
    }
}