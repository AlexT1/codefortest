package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName DivisibleSumPairsSolution
 * @Description TODO()
 * @date 2018/3/20 17:56:58
 */
public class DivisibleSumPairsSolution {
    static int divisibleSumPairs(int n, int k, int[] ar) {
        // Complete this function
        int i = 0, count = 0, result = 0;
        do {
            count = recursiveMethod(i,n-1,k,ar);
            if (count!= 0) {
                result = result + count;
            }
            i++;
        } while (i < n);
        return result;
    }

    public static int recursiveMethod(int a, int b, int des, int[] s){
        int temp = 0, count = 0, index = a, nextIndex = a+1;
        for (int i = a; i < b; i++) {
            temp = s[index]  + s[nextIndex];
            nextIndex++;
            if (temp%des == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] ar = new int[n];
//        for(int ar_i = 0; ar_i < n; ar_i++){
//            ar[ar_i] = in.nextInt();
//        }
        int[] ar = {1,3,2,6,1,2};
        int n=6, k=3;
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}
