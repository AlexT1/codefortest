package com.alexstudy.hackrank;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName AppleAndOrange
 * @Description TODO()
 * @date 2018/3/9 11:06:26
 */
public class AppleAndOrange {
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        // Complete this function
        if (s < 1 || t < 1 || a < 1 || b < 1 || apples.length < 1 || oranges.length < 1){
            return;
        }
        int i=0,j=0;
        for (int apple: apples){
            if ((a - apple) >= s && (a - apple) <= t)
                i = i+1;
        }
        for (int orange: oranges){
            if ((b - orange) >= s && (b - orange) <= t)
                j = j+1;
        }
        System.out.println(i);
        System.out.println(j);
        i=0;
        j=0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i = 0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i = 0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        countApplesAndOranges(s, t, a, b, apple, orange);
        in.close();
    }
}
