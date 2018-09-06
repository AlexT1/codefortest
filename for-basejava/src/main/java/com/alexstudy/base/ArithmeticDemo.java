package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName ArithmeticDemo
 * @Description TODO()
 * @date 2018/9/4 15:55:52
 */
public class ArithmeticDemo {
    public static void main (String[] args) {

        int result = 1 + 2;
        // result is now 3
        System.out.println("1 + 2 = " + result);
        int original_result = result;

        //int result = 1 + 2; //following marked code is for exercise
        //change to below
//        result = 3;
//        result -= 1;
//        System.out.println("-= : " + result);
//        result *= 2;
//        System.out.println("*= ：" + result);
//        result /= 2;
//        System.out.println("/= : " + result);
//        result += 8;
//        System.out.println("+= : " + result);
//        result %= 7;
//        System.out.println("%= : " + result);

        result = result - 1;
        // result is now 2
        System.out.println(original_result + " - 1 = " + result);
        original_result = result;

        result = result * 2;
        // result is now 4
        System.out.println(original_result + " * 2 = " + result);
        original_result = result;

        result = result / 2;
        // result is now 2
        System.out.println(original_result + " / 2 = " + result);
        original_result = result;

        result = result + 8;
        // result is now 10
        System.out.println(original_result + " + 8 = " + result);
        original_result = result;

        result = result % 7;
        // result is now 3
        System.out.println(original_result + " % 7 = " + result);
    }
}
