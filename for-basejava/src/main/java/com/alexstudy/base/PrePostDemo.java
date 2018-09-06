package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName PrePostDemo
 * @Description TODO()
 * @date 2018/9/4 16:37:51
 */
public class PrePostDemo {
    public static void main(String[] args){
        int i = 3;
        i++;
        // prints 4
        System.out.println(i);
        ++i;
        // prints 5
        System.out.println(i);
        // prints 6
        System.out.println(++i);
        // prints 6
        System.out.println(i++);
        // prints 7
        System.out.println(i);
    }
}
