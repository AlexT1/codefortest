package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName DoWhileDemo
 * @Description TODO()
 * @date 2018/9/6 18:25:07
 */
public class DoWhileDemo {
    public static void main(String[] args){
        int count = 1;
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
    }
}
