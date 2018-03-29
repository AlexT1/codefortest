package com.alexstudy.hackrank.Algorithms.Implementation;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author AlexTong
 * @ClassName BetweenTwoSetsSolution
 * @Description TODO()
 * @date 2018/3/12 11:35:51
 */
public class BetweenTwoSetsSolution2 {

    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        /**
         * The first case: max array a value / min array a value == 0
         * max array b value / min array b value == 0
         * so max array a << 1 and min array b value / max array a << 1 == 0, this value is expect value and count.
         * */
        int min_arrayb, max_arrayb;
        int min_arraya, max_arraya;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        min_arraya = min(a);
        max_arraya = max(a);
        min_arrayb = min(b);
        max_arrayb = max(b);
        int random = 2;
        int random_two = 3;
        if ((max_arraya%min_arraya == 0) && (countBit(max_arraya) == 1)) {
            if (min_arraya == 1 || min_arrayb == 1) {
                map.put(count,min_arraya);
                count++;
            }
            if (min_arrayb != 1 && (max_arrayb%min_arrayb == 0) && (min_arrayb%random == 0)) {
                while (min_arrayb % max_arraya == 0) {
                    max_arraya = max_arraya << 1;
                    map.put(count, max_arraya);
                    count++;
                }
                int random3 = 0;
                if (countBit(b[0])!=1) {
                   random3 = max_arraya + random;
                }
                random=random3;
                while (min_arrayb%random == 0){
                    map.put(count,random);
                    count++;
                    random = random3 + random;
                    if (countBit(random) > 3) {
                        random = random3 + random + random3;
                    }
                }
                if (b.length==1) {
                    map.put(count,b[0]);
                    count++;
                }
                int tmp_value = max_arrayb;
                while (max_arrayb%tmp_value == 0){
                    tmp_value = tmp_value >> 1;
                    map.put(count,tmp_value);
                    count++;
                }
                Set<Integer> set = new HashSet<Integer>();
                for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                    if (b[0]%entry.getValue() ==0) {
                        set.add(entry.getValue());
                    }
                }
                count = set.size();
                return count;
            } else {
                //max_arrayb % min_arrayb != 0

                if (min_arrayb == 1) {
                    map.put(count,min_arrayb);
                    count++;
                }
                map = countTotal(random,min_arrayb,max_arraya,map,count, max_arrayb);
                count = map.size();
                map = countTotal(random_two,min_arrayb,max_arraya,map,count, max_arrayb);

                Set<Integer> set = new HashSet<Integer>();
                for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                    if (b[0]%entry.getValue() ==0) {
                        set.add(entry.getValue());
                    }
                }
                count = set.size();
                return count;

            }
        } else {
            if (max_arrayb%min_arrayb == 0) {
                map.put(count,min_arrayb);
                count++;
                int tmp_value = min_arrayb;
                while (tmp_value%max_arraya == 0) {
                    map.put(count,tmp_value);
                    tmp_value = tmp_value >> 1;
                    count++;
                }
            }
            map = countTotal(random,min_arrayb,max_arraya,map,count, max_arrayb);
            count = map.size();
            map = countTotal(random_two,min_arrayb,max_arraya,map,count, max_arrayb);
            Set<Integer> set = new HashSet<Integer>();
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if ((b[0]%entry.getValue() ==0) && (entry.getValue()%a[a.length-1] == 0)) {
                    set.add(entry.getValue());
                }
            }
            count = set.size();
            return count;

        }
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
            if (array[i] < array[minIndex]) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minValue;
    }

    private static int max(int[] array) {
        int maxIndex=0, maxValue =array[maxIndex];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex])
                maxValue = array[i];
                maxIndex = i;
        }
        return maxValue;
    }

    private static HashMap<Integer, Integer> countTotal(int binary, int arrayValue, int maxa, HashMap<Integer, Integer> map, int index,int maxArrayValue) {
        int countTotal = index;
        HashMap<Integer, Integer> return_map = map;
        while (binary < 100) {
            if ((arrayValue%binary == 0) && (binary%maxa == 0) && (maxArrayValue%binary == 0)) {
                    return_map.put(countTotal, binary);
                    countTotal++;
            }
            binary = binary << 1;
        }
        return return_map;
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
//        int[] a = {1};
//        int[] b={72,48};
//        int[] a = {2};
////        int[] b={20,30,12};
//        int[] a={72,48};
//        int[] b={20,30,12};

//        int[] a = {2,3,6};
//        int[] b = {42,84};
//        int[] a = {3,9,6};
//        int[] b = {36,72};
        int[] a = {1};
        int[] b = {100};
        int total = getTotalX(a, b);
        System.out.println(total);
        // in.close();
    }
}
