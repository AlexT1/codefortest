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
        int contains = 0;
       contains = containsAcount(s);

        if (s.length() < n) {
            if (n - s.length() > s.length()) {
                s.concat(s);
                contains = contains * 2;
            } else {
                String temp = s.substring(0, Math.toIntExact(n-s.length()));
                s.concat(temp);
                contains += containsAcount(temp);
            }
        } else {
            s.substring(0, Math.toIntExact(n));
            contains += containsAcount(s);
        }
        return contains;
    }
    static int containsAcount(String source) {
        int res = 0;
        for(char c: source.toCharArray()){
            if ( c == 'a'){
                res++;
            }
        }
        return res;
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
