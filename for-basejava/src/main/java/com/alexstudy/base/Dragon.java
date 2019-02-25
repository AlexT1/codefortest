package com.alexstudy.base;

/**
 * @ClassName Dragon
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/28
 */
public class Dragon implements EggLayer, FireBreather {
//     public String identifyMyself() {
//        return "I am able to Dragon.";
//    }
    public static void main (String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}