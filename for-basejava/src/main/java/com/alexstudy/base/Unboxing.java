package com.alexstudy.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Unboxing
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/1/21
 */
public class Unboxing {
    public static void main(String[] args) {
        String original = "software";
        StringBuilder result = new StringBuilder("hi");
        int index = original.indexOf('a');

/*1*/   result.setCharAt(0, original.charAt(0));
/*2*/   result.setCharAt(1, original.charAt(original.length()-1));
/*3*/   result.insert(1, original.charAt(4));
/*4*/   result.append(original.substring(1,4));
/*5*/   result.insert(3, (original.substring(index, index+2) + " "));

        System.out.println(result);
    }
//    public static void main(String[] args) {
//
//        Integer i = new Integer(-8);
//
//        // 1. Unboxing through method invocation
//        int absVal = absoluteValue(i);
//        System.out.println("absolute value of " + i + " = " + absVal);
//
//        List<Double> ld = new ArrayList<>();
//        ld.add(3.1416);    // PI is autoboxed through method invocation.
//
//        // 2. Unboxing through assignment
//        double phi = ld.get(0);
//        System.out.println("phi = " + phi);
//    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }
}
