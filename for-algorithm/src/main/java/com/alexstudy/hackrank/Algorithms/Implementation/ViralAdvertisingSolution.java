package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName ViralAdvertisingSolution
 * @Description TODO()
 * @date 2018/4/9 14:41:10
 */
public class ViralAdvertisingSolution {
    static int viralAdvertising(int n) {
        // Complete this function
        int result = 0, initPeople = 5, temp = 0;
        for (int i = 1; i <= n; i++) {
            if (temp == 0) {
                temp = initPeople/2;
                result = result + temp;
                temp = initPeople;
            } else{
                temp = temp/2 * 3;
                result = result + temp/2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = viralAdvertising(n);
        System.out.println(result);
        in.close();
    }
}
