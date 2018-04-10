package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author AlexTong
 * @ClassName SavePrisonerSolution
 * @Description TODO()
 * @date 2018/4/9 14:47:54
 */
public class SavePrisonerSolution {
    private static int LAST_SIT = 0;
    static int saveThePrisoner(int n, int m, int s){
        // Complete this function
        int result = 0;
        //when 999999999 999999999 2   Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        Integer[] prisoner = IntStream.range(1, n)  // n is the array size
//                .mapToObj(i -> (i))
//                .toArray(Integer[]::new);

        if (n > m && m > s) {
            if (LAST_SIT < n) {
                result = LAST_SIT + (n - LAST_SIT) % s;
            } else {
                //System.out.println(LAST_SIT%n);
                result = (LAST_SIT%n) + (n - LAST_SIT) % s;
            }
        } else if (m == n) {
            result = (n-LAST_SIT)%s;
        } else {
            if (LAST_SIT < n) {
                result = m%(n%s) - LAST_SIT;
            } else {
//                System.out.println(LAST_SIT%n);
//                System.out.println((m%(LAST_SIT+n)));
                int temp = m%(LAST_SIT+n);
//                System.out.println(temp%s);
                result = LAST_SIT%n + (LAST_SIT%n)%m%s ;
            }

        }
        LAST_SIT = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }
}