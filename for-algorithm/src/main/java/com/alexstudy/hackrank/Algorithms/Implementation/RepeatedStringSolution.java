package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName RepeatedStringSolution
 * @Description TODO()
 * @date 2018/4/23 17:34:27
 */
public class RepeatedStringSolution {
//    The first line contains a single string, s.
//    The second line contains an integer, n.
    static long repeatedString(String s, long n) {
        // Complete this function
        if (s.length() < n) {
            StringBuilder stringBuilder = new StringBuilder(s);
        } else {
            s.substring(0, Math.toIntExact(n));
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long result = repeatedString(s, n);
        System.out.println(result);
        in.close();
    }
}
