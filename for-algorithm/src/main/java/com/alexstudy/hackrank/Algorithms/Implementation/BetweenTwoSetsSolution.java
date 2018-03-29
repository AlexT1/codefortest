package com.alexstudy.hackrank.Algorithms.Implementation;


import java.util.HashMap;
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
        int maxb = max(b);
        int mina = min(a);
        int minb = min(b);
        int arraySize =0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int binary = 0;

        if ((countBit( b[0]& 0xf0) != 1 && countBit(b[0]&0x0f) != 1)) {
            return 0;
        }
        binary = maxb >> 1;
        map = countTotal(binary,minb,mina, map,arraySize);
        binary = minb >> 1;
        map.putAll(countTotal(binary,maxb,mina,map,map.size()));
        arraySize = map.size();
        int[] result = new int[arraySize];
        int i = 0;
        for (Integer value : map.values()) {
            result[i] = value;
            i++;
        }
        for (int re_element: result) {
            int tmp = 0;
            if (re_element != 0 && max(result) % re_element == 0) {
                tmp = max(result) / re_element;
                if (!iteratorArray(result,tmp)) {
                    result[arraySize-1] = max(result) % re_element;
                }
            }
        }
        return arraySize;
    }

    private static int countBit(int num) {
        int count = 0;
        for (; num > 0; count++) {
            num &= (num - 1);
        }
        return count;
    }

    private static int min(int[] array) {
        int minIndex = 0, minValue = array[minIndex];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minIndex])
                minValue = array[i];
        }
        return minValue;
    }

    private static int max(int[] array) {
        int maxIndex=0, maxValue =array[maxIndex];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex])
                maxValue = array[i];
        }
        return maxValue;
    }

    private static HashMap<Integer, Integer> countTotal(int binary, int arrayValue, int mina, HashMap<Integer, Integer> map, int index) {
        int countTotal = index;
        HashMap<Integer,Integer> return_map = map;
        while (binary > 0) {
            if (arrayValue%binary == 0 && binary%mina == 0) {
                return_map.put(countTotal,binary);
                countTotal = countTotal + 1;
            }
            binary = binary >> 1;
        }
        return return_map;
    }

    private static boolean iteratorArray(int[] array, int value) {
        for (int element : array) {
            if (value == element) {
                return true;
            }
        }
        return false;
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
//        int[] a = {2, 4};
//        int[] b = {16, 32, 96};
        int[] a = {1};
        int[] b={72,48};
//        int[] a = {2};
//        int[] b={20,30,12};

        int total = getTotalX(a, b);
        System.out.println(total);
        // in.close();
    }
}
