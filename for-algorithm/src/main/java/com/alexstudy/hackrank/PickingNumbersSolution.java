package com.alexstudy.hackrank;

import java.util.*;

/**
 * @author AlexTong
 * @ClassName PickingNumbersSolution
 * @Description TODO()
 * @date 2018/3/27 16:20:45
 */
public class PickingNumbersSolution {
    //fist not optimize
//    static int pickingNumbers(int[] a) {
    // Complete this function
//        List<Integer> confirm = new ArrayList<>();
//        confirm.add(a[0]);
//        for(int j = 1; j < a.length; j++){
//            if (Math.abs(a[0] - a[j]) <= 1) {
//                confirm.add(a[j]);
//            }
//        }
//        for(int k = 1; k < confirm.size(); k++){
//            if (k+1 < confirm.size()) {
//                if (Math.abs(confirm.get(k).intValue() - confirm.get(k + 1).intValue()) > 1) {
//                    confirm.remove(k);
//                }
//            }
//        }
//        return confirm.size();
//    }

    static int pickingNumbers(int[] a) {
        // Complete this function
        int count = 0, temp = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        Arrays.sort(a);
        if (Math.abs(a[0] - a[a.length - 1]) <= 1) {
            return a.length;
        }
        for (int d = 0; d < a.length; d++) {
            if (treeMap.containsKey(a[d])) {
                treeMap.put(a[d], treeMap.get(a[d]).intValue() + 1);
            } else {
                treeMap.put(a[d], 1);
            }
        }
        for (Integer values : treeMap.values()) {
            if (count == 0 || values > count) {
                count = values;
            }
        }
        Object[] keyArrays = treeMap.keySet().toArray();
        for (int t = 0; t < keyArrays.length; t++) {
            if (t + 1 < keyArrays.length) {
                if (Math.abs(Integer.valueOf(keyArrays[t].toString()) - Integer.valueOf(keyArrays[t + 1].toString())) <= 1) {
                    temp = treeMap.get(keyArrays[t]) + treeMap.get(keyArrays[t + 1]);
                    if (temp > count) {
                        count = temp;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] a = new int[n];
//        for(int a_i = 0; a_i < n; a_i++){
//            a[a_i] = in.nextInt();
//        }
//        int[] a = {4, 6, 5, 3, 3, 1};
//        int[] a = {1,2,2,3,1,2};
//       int[] a = {98,3,99,1,97,2};
//        int[] a = {66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66, 66};
        int[] a = {9, 6, 13, 16, 5, 18, 4, 10, 3, 19, 4, 5, 8, 1, 13, 10, 20, 17, 15, 10, 6, 10, 13, 20, 18, 17, 7, 10, 6, 5, 16, 18, 13, 20, 19, 7, 16, 13, 20, 17, 4, 17, 8, 19, 12, 7, 17, 1, 18, 3, 16, 4, 5, 3, 15, 17, 6, 17, 14, 11, 11, 7, 11, 6, 15, 15, 12, 6, 17, 19, 8, 6, 13, 9, 10, 19, 14, 18, 7, 9, 11, 16, 11, 20, 4, 20, 10, 7, 8, 4, 2, 12, 11, 8, 12, 13, 19, 8, 8, 5};
//        int[] a = {7,12,13,19,17,7,3,18,9,18,13,12,3,13,7,9,18,9,18,9,13,18,13,13,18,18,17,17,13,3,12,13,19,17,19,12,18,13,7,3,3,12,7,13,7,3,17,9,13,13,13,12,18,18,9,7,19,17,13,18,19,9,18,18,18,19,17,7,12,3,13,19,12,3,9,17,13,19,12,18,13,18,18,18,17,13,3,18,19,7,12,9,18,3,13,13,9,7};
//       int[] a = {4,97,5,97,97,4,97,4,97,97,97,97,4,4,5,5,97,5,97,99,4,97,5,97,97,97,5,5,97,4,5,97,97,5,97,4,97,5,4,4,97,5,5,5,4,97,97,4,97,5,4,4,97,97,97,5,5,97,4,97,97,5,4,97,97,4,97,97,97,5,4,4,97,4,4,97,5,97,97,97,97,4,97,5,97,5,4,97,4,5,97,97,5,97,5,97,5,97,97,97};
        int result = pickingNumbers(a);
        System.out.println(result);
//        in.close();
    }
}
