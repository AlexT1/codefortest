package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.HashMap;
import java.util.Map;
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
//    Pattern pattern = Pattern.compile("^[^\\*]*\\*+.*$"); //regex
    static long repeatedString(String s, long n) {
        // Complete this function
        int otherCharacter = 0;
        String temp = "a";
        Long size = 0l,index = 0l;
        Map<Long,Integer> map = new HashMap<Long, Integer>();
        if (s.equals(temp) != false || s.compareToIgnoreCase(temp) == s.length()) {
            return n;
        }
        for(char c : s.toCharArray()){
            if (c != temp.charAt(0)) {
                otherCharacter++;
            }
            map.put(index,otherCharacter);
            index++;
        }
        if (n%s.length() == 0) {
            size = n - otherCharacter * (n / s.length());
        } else if (n%s.length() != 0) {
            index = n % s.length() - 1;
            size = n - otherCharacter * (n / s.length()) - map.get(index);
        }
        return size;
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
