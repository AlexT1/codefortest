package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Map;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName SherlockSquaresSolution
 * @Description TODO()
 * @date 2018/4/16 18:19:58
 */
public class SherlockSquaresSolution {
    static int squares(int a, int b) {
        // Complete this function
        int result = 0, mid_index = 0;
        int sq_a = (int) Math.sqrt(a);
        if (sq_a == Math.sqrt(a)) {
            result++;
        }
        mid_index = sq_a+1;
        while (mid_index*mid_index <= b){
            result++;
            mid_index++;
        }

//  Brute force, time due
//        for(int i = a; i <= b; i++) {
//
//            if(Integer.valueOf((int) Math.sqrt(i)) == Math.sqrt(i)) {
//                result++;
//            }
//        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int result = squares(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
