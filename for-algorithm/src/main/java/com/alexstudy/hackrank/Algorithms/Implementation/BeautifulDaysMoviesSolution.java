package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName BeautifulDaysMoviesSolution
 * @Description TODO()
 * @date 2018/4/9 14:40:17
 */
public class BeautifulDaysMoviesSolution {
    static int beautifulDays(int i, int j, int k) {
        // Complete this function
        int result = 0;
        for (int m = i; m <= j; m++) {
            if (Math.abs(m - reverse(m)) % k == 0) {
                result++;
            }
        }
        return result;
    }

    static int reverse(int number){
        int res = 0;
        while(number != 0){
            res = res * 10 + number % 10;
            number = number/10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
