package com.alexstudy.hackrank;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName CountingValleysSolution
 * @Description TODO()
 * @date 2018/3/22 17:39:40
 */
public class CountingValleysSolution {
    static int countingValleys(int n, String s) {
        // Complete this function
        Map<Integer,Integer> map = new Hashtable<>(n);
        String up = "U";
        String down = "D";
        int count=0;
        System.out.println(s.indexOf("D"));
        for (int i = 0; i < n; i++) {
            System.out.println(s.codePointAt(i));
//            if (map.containsKey(s.indexOf(i))) {
//                map.put(s.indexOf(i), map.get(i)+1);
//            } else {
//                map.put(s.indexOf(i), count+1);
//            }
        }
        System.out.println(map.toString());
        return 0;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String s = in.next();
        int n = 8;
        String s = "UDDDUDUU";
        int result = countingValleys(n, s);
        System.out.println(result);
//        in.close();
    }
}
