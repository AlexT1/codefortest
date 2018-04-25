package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName EqualizeArraySolution
 * @Description TODO()
 * @date 2018/4/24 18:18:58
 */
public class EqualizeArraySolution {
//    The first line contains an integer n, the number of elements in arr.
//    The next line contains n space-separated integers arr[i].
    static int equalizeArray(int[] arr) {
        // Complete this function
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i: arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = equalizeArray(arr);
        System.out.println(result);
        in.close();
    }
}
