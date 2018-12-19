package com.alexstudy.base;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author AlexTong
 * @ClassName EnhancedForDemo
 * @Description TODO()
 * @date 2018/9/11 14:08:52
 */
public class EnhancedForDemo {
//    public static void main(String[] args){
//        DateUtil.
//        int[] numbers =
//                {1,2,3,4,5,6,7,8,9,10};
//        for (int item : numbers) {
//            System.out.println("Count is: " + item);
//        }
//    }
public static void main(String[] args){
    System.out.println(System.getProperty("usr.dir"));
    String s = "C:\\fakepath\\20181029.xls";
    String[] arr = s.split(".");
    for(String s1:arr){
        System.out.println(s1);
    }
}
}
