package com.alexstudy.hackrank;


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
public class BetweenTwoSetsSolution3 {

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
        int i = 1;
        if (min_arraya == 1 && max_arraya == 1) {
            map.put(count, min_arraya);
            count++;
            if (min_arrayb == 1) {
                count++;
                return count;
            }
        }
        if (max_arraya % min_arraya == 0 && max_arrayb % min_arrayb == 0) {
            if (min_arrayb % max_arraya == 0) {
                map.put(count, min_arrayb);
                count++;
                do {
                    if (min_arrayb % i == 0 && i % max_arraya == 0) {
                        map.put(count, i);
                        count++;
                        if ((min_arrayb / i) % max_arraya == 0) {
                            map.put(count, min_arrayb / i);
                            count++;
                        }
                    }

                    i++;
                } while (i <= 10);
            }
        } else {
            if (max_arrayb % min_arrayb != 0) {
                if (max_arraya % min_arraya != 0) {
                    int temp = max_arraya * min_arraya;
                    int result = 1;
                    do {
                        if (temp % i == 0) {
                            result = result * i;
                        }
                    } while (i <= 10);
                    if (result > temp) {
                        max_arraya = temp;
                    } else {
                        max_arraya = result;
                    }
                }
                do {
                    if (min_arrayb % i == 0 && max_arrayb % i == 0 && i % max_arraya == 0) {
                        map.put(count, i);
                        count++;
                        if ((min_arrayb / i) % max_arraya == 0 && (min_arrayb / i) % max_arraya == 0) {
                            map.put(count, min_arrayb / i);
                            count++;
                        }
                    }
                    i++;
                } while (i <= 10);
            }

        }

        Set<Integer> set = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (b[0] % entry.getValue() == 0) {
                set.add(entry.getValue());
            }
        }
        count = set.size();
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
        int maxIndex = 0, maxValue = array[maxIndex];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex])
                maxValue = array[i];
            maxIndex = i;
        }
        return maxValue;
    }
    public static String getUnicode(String source){
        String returnUniCode=null;
        String uniCodeTemp=null;
        for(int i=0;i<source.length();i++){
            uniCodeTemp = "\\u"+Integer.toHexString((int)source.charAt(i));//使用char类的charAt()的方法
            returnUniCode=returnUniCode==null?uniCodeTemp:returnUniCode+uniCodeTemp;
        }
        System.out.print(source +" 's unicode = "+returnUniCode);
        return returnUniCode;//返回一个字符的unicode的编码值
    }

    public static void main(String[] args) {
        int[] test = {4,3,2,3};
        for(int i : test){
            System.out.println( "i " + i + "  " + getUnicode(String.valueOf(i)));
        }

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
        int[] a = {2, 4};
        int[] b = {16, 32, 96};
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
//        int[] a = {1};
//        int[] b = {100};
        int total = getTotalX(a, b);
        System.out.println(total);
        // in.close();
    }
}
