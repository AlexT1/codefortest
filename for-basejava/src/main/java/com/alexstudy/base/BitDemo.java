package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName BitDemo
 * @Description TODO()
 * @date 2018/9/4 17:59:12
 */
public class BitDemo {
    public static void main(String[] args) {
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(" 0b bitmask: " + Integer.toBinaryString(bitmask) + "  0b val: " + Integer.toBinaryString(val));
        System.out.println(val & bitmask);
        int i = 0x1112;
        System.out.println(" 0b i: " + Integer.toBinaryString(i) + "  0b i oper : " + Integer.toBinaryString(i << 6));
    }
}
