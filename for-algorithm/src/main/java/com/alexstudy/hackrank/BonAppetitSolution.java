package com.alexstudy.hackrank;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName BonAppetitSolution
 * @Description TODO()
 * @date 2018/3/22 10:02:35
 */
public class BonAppetitSolution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int b = in.nextInt();
        int total = 0;
        for (int i = 0; i < c.length; i++) {
            if (i != k){
                total = total + c[i];
            }
        }
        int result = (total/2 == b) ? 0 : b - total/2;
        System.out.println(result == 0 ? "Bon Appetit" : result);
    }
}
