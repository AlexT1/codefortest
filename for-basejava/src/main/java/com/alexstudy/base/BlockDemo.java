package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName BlockDemo
 * @Description TODO()
 * @date 2018/9/5 17:29:04
 */
public class BlockDemo {
    public static void main(String[] args) {
        boolean condition = true;
        if (condition) { // begin block 1
            System.out.println("Condition is true.");
        } // end block one
        else { // begin block 2
            System.out.println("Condition is false.");
        } // end block 2
    }
}
