package com.alexstudy.hackrank.Algorithms.Implementation;

import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName AppendDeleteSolution
 * @Description TODO()
 * @date 2018/4/16 15:02:43
 */
public class AppendDeleteSolution {
//    The first line contains a string , s the initial string.
//    The second line contains a string , t the desired final string.
//    The third line contains an integer , k the number of operations.
//  also can be optimized, not perfect
    static String appendAndDelete(String s, String t, int k) {
        // Complete this function
//y
// yu
// 2
        if (t.length() > s.length() && t.endsWith(s)){
            return "Yes";
        }
        System.out.println(s.compareTo(t));
        if (t.length() < s.length() && s.compareTo(t) >= k || t.length() >= k && t.length() == s.length() && t.compareTo(s) != 0
                || t.length() > s.length() && (s.length() + k < t.length() || k - s.length() < t.length())) {
            return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
//        zzzzz
//        zzzzzzz
//        4
//        asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv
//        asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv
//        20
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        in.close();
    }
}
