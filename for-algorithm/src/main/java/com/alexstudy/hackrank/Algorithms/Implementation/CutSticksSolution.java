package com.alexstudy.hackrank.Algorithms.Implementation;

import com.google.common.primitives.Ints;

import java.util.*;

/**
 * @author AlexTong
 * @ClassName CutSticksSolution
 * @Description TODO()
 * @date 2018/4/19 14:19:03
 */
public class CutSticksSolution {
    static int[] cutTheSticks(int[] arr) {
        // Complete this function
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(arr);
        //Solution.java:14: error: local variable arr is accessed from within inner class; needs to be declared final
        final int[] f_arr = arr;
        List<Integer> in_arr = new ArrayList<Integer>(){{ for (int i : f_arr) add(i); }};
//        List<Integer> in_arr = new ArrayList<Integer>();
//        in_arr = Ints.asList(arr);
        int sub_value = 0;
//        initial int[] to list<Integer> both ok
//        List<Integer> in_arr = new ArrayList<Integer>(){{ for (int i : arr) add(i); }};
//        in_arr = Ints.asList(arr);
        // in java 8 List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // or Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> temp_arr = new LinkedList<Integer>();
        do {
                for (int element : in_arr) {
                    sub_value = element - in_arr.get(0);
                    if ( sub_value == 0) {
                        temp_arr.add(element);
                    }
                }
                result.add(in_arr.size());
                sub_value = in_arr.get(0);
                for (int element : temp_arr) {
                    in_arr.remove(in_arr.indexOf(element));
                }
            for (int i = 0; i < in_arr.size(); i++) {
                in_arr.set(i,in_arr.get(i)-sub_value);
            }
            temp_arr.clear();
        } while (in_arr.size() >= 1);
        //in java 8 int[] arr = list.stream().mapToInt(i -> i).toArray();
        return Ints.toArray(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = cutTheSticks(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
