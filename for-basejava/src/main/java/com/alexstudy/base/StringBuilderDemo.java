package com.alexstudy.base;

/**
 * @ClassName StringBuilderDemo
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/1/21
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);

        sb.reverse();  // reverse it

        System.out.println(sb);
    }
}
