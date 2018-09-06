package com.alexstudy.base;

import java.util.Arrays;

/**
 * @author AlexTong
 * @ClassName ArrayCopyDemo
 * @Description TODO()
 * @date 2018/9/3 18:07:45
 */
public class ArrayCopyDemo {
    //System.arraycopy() method
//    public static void main(String[] args) {
//        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
//                'i', 'n', 'a', 't', 'e', 'd' };
//        char[] copyTo = new char[7];
//
//        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
//        System.out.println(new String(copyTo));
//
//    }

    // The difference is that using the copyOfRange method does not require you to create the destination array
    // before calling the method, because the destination array is returned by the method
    public static void main(String[] args) {
        int i = ~ 15;
        System.out.println(i + "   0b :" + Integer.toBinaryString(i));
        System.out.println(!false);
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));
        System.out.println("sort :" + System.currentTimeMillis());
        Arrays.sort(copyTo);
        System.out.println("sort end :" + System.currentTimeMillis());
        System.out.println(new String(copyTo));
       // Arrays.fill(copyTo, 'a');  //aaaaaaa
        Arrays.fill(copyTo,2,5, 'a'); // caaaain
        System.out.println(new String(copyTo));
        System.out.println("paralle :" + System.currentTimeMillis());
        Arrays.parallelSort(copyTo);
        System.out.println( "paralle end :" + System.currentTimeMillis());
        System.out.println(new String(copyTo));

    }
}
