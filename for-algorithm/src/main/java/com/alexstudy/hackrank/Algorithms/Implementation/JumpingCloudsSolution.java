package com.alexstudy.hackrank.Algorithms.Implementation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName JumpingCloudsSolution
 * @Description TODO()
 * @date 2018/4/24 11:23:08
 */
public class JumpingCloudsSolution {
    static int jumpingOnClouds(int[] c) {
        // Complete this function
        int res = 0, temp = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < c.length; i++) {
            if (c[i] != 0) {
                map.put(i,c[i]);
            }
        }

        do {
            if(map.containsKey(temp+1)){
                temp+=2;
            } else if(map.containsKey(temp+2)){
                temp+=1;
            } else {
                temp+=2;
            }
            res++;
        } while (temp < c.length-1);
//        if (c.length%2 != 0) {
//            res = res-1;
//        }
        return res;
    }

    public static void main(String[] args) {
//        BigDecimal sumAmount = new BigDecimal(0);
//        BigDecimal sum = new BigDecimal(2162.92);
//        sumAmount = sumAmount.add(sum);
//        System.out.println(sumAmount);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }
}
