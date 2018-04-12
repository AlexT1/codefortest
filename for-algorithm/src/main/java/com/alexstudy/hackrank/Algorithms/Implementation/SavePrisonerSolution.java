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
    static int saveThePrisoner(int n, int m, int s){
        // Complete this function
        //java 8 give int n to be a sequence array
//        Integer[] prisoner = IntStream.range(1, n)  // n is the array size
//                .mapToObj(i -> (i))
//                .toArray(Integer[]::new);

        // Complete this function
        //n : the number of prisoners
        //m : the number of sweets
        //s : the chair number to start passing out treats at
        
        if(n== 0 || m==0)
        return 0;
        if(s+m-1 <= n){
            return s+m-1;
        }
        else{
            if((s+m-1)%n==0)
                return n;
            else
                return (s+m-1)%n;
        }
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
