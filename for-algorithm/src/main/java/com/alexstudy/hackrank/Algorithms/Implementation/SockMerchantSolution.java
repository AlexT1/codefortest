package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName SockMerchantSolution
 * @Description TODO()
 * @date 2018/3/22 10:41:12
 */
public class SockMerchantSolution {
    static int sockMerchant(int n, int[] ar) {
        // Complete this function
        Map<Integer,Integer> map = new Hashtable<>(n);
        int count=0, result=0;
        for (int element : ar) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            } else {
                map.put(element, count+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue()%2 == 0) {
                result = result + entry.getValue()/2;
            } else {
                result = result + (entry.getValue()-1)/2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int ar_i = 0; ar_i < n; ar_i++){
//            ar[ar_i] = in.nextInt();
//        }
        int n = 9;
        int[] ar = {10,20,20,10,10,30,50,10,20};
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
