package com.alexstudy.hackrank;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName BetweenTwoSetsSolution
 * @Description TODO()
 * @date 2018/3/12 11:35:51
 */
public class BetweenTwoSetsSolution {

    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int maxa = max(a);
        int maxb = max(b);
        int mina = min(a);
        int minb = min(b);
        int arraySize =0;
        int tmp =maxb >> 1;
        int bitAcount = countBit(a[0]);

        int binary = 0,j=0,k=0;
//        int bitAcount = countBit(a[0]);
        int bitBcount = countBit(b[0]);
//        if (a[0] == 1) {
//            result[j] = 1;
//            j++;
//        }
        if (bitAcount==1 && bitBcount==1) {
            for (int a_element: a) {
                binary = a_element << 1;
                if (binary%a_element == 0) {
                    arraySize = arraySize+1;
                  //  result[j] = binary;
                    j++;
                }
            }
            if (minb%(binary<<1) == 0) {
             //   result[j] = minb;
                arraySize = arraySize+1;
                j++;
            }

        }  else {
            if ((countBit(b[0] & 0xf0) >> 4) == 1 && countBit(b[0] & 0x0f) == 1) {
               int min_element=min(b);
                if (min_element%(min_element >> 1)== 0){
                    binary = min_element >> 1;
                }
            }
            return 0;
        }
//        int count = 0;
//        for(int re: result) {
//            if (re!=0) {
//                System.out.println(re);
//                count++;
//            }
//        }
//        return count;
        return arraySize;
    }
    private static int countBit(int num){
        int count = 0;
        for(; num > 0; count++) {
            num &= (num - 1);
        }
        return count;
    }
    private static int min(int[] array){
        int minValue = array[0];
        for (int i = 0; i<array.length;i++){
            if (array[i]<minValue)
                minValue = array[i];
        }
        return minValue;
    }
    private static int max(int[] array){
        int maxValue = array[0];
        for (int i = 0; i<array.length;i++){
            if (array[i] > maxValue)
                maxValue = array[i];
        }
        return maxValue;
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] a = new int[n];
//        for(int a_i = 0; a_i < n; a_i++){
//            a[a_i] = in.nextInt();
//        }
//        int[] b = new int[m];
//        for(int b_i = 0; b_i < m; b_i++){
//            b[b_i] = in.nextInt();
//        }
//        int[] a = {2,4};
//        int[] b = {16,32,96};
        int[] a = {1};
        int[] b={72,48};

        int total = getTotalX(a, b);
        System.out.println(total);
       // in.close();
    }
}
