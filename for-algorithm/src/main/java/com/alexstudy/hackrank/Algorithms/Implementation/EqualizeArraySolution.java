package com.alexstudy.hackrank.Algorithms.Implementation;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author AlexTong;
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
        int max = 1;
        for(int i: arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
                if (map.get(i) > max) {
                    max = map.get(i);
                }
            } else {
                map.put(i,1);
            }
        }
        return arr.length - max;
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
