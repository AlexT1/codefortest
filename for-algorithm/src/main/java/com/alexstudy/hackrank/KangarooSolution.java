package com.alexstudy.hackrank;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName KangarooSolution
 * @Description TODO()
 * @date 2018/3/9 13:15:39
 */
public class KangarooSolution {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function

        if ((x2 > x1 && v1 < v2) || (x2 < x1 && v2 < v1)){
            return "NO";
        }
        else if (((v2 - v1) > 0 && (v2 - v1) < v1 ) || ((v1 - v2) > 0 && (v1 - v2) < v2)){
            //return loopJumpMeters(x1,v1,x2,v2);
            return "YES";
        }
        return "NO";
    }

    static String loopJumpMeters(int x1, int v1, int x2, int v2){
        for (int i = 0; i < v1; i++){
            x1 = x1 + v1;
            x2 = x2 + v2;
            if ((x2 > x1 && (x2-x1) > v1) || (x1 > x2 && (x1-x2) > v2)) {
                return "NO";
            }
            if (x1 == x2) {
                return "YES";
            }
        }

        return "No";

    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x1 = in.nextInt();
//        int v1 = in.nextInt();
//        int x2 = in.nextInt();
//        int v2 = in.nextInt();
//        String result = kangaroo(x1, v1, x2, v2);
//        System.out.println(result);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int x1 = in.nextInt();
//        int v1 = in.nextInt();
//        int x2 = in.nextInt();
//        int v2 = in.nextInt();
        String result = kangaroo(23, 9867, 9814, 5861);
        System.out.println(result);
    }
}
