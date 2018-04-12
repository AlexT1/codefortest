package main.java.com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.*;

/**
 * Created by Alex on 2018/4/12.
 */
public class SherlockWatsonSolution {
    //int[] a 最初数组A的元素
    //int[] m 一共有Q个查询
    //k 右循环的次数
    static int[] circularArrayRotation(int[] a, int[] m, int k) {
        // Complete this function
        int[] resultArray = new int[m.length];
        int index = 0;
        List<Integer> arrayList = new ArrayList<Integer>();
        if (a.length - k > 0) {
            index = a.length - k;
        } else {
            //if a.lengt - k == 0, it means array not need to convert
            index = a.length - k % a.length;
        }

        for (int i = index; i < a.length; i++) {
            arrayList.add(a[i]);
        }
        for (int i = 0; i < index; i++) {
            arrayList.add(a[i]);
        }

        for (int j = 0; j < m.length; j++) {
            resultArray[j] = arrayList.get(m[j]);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] m = new int[q];
        for (int m_i = 0; m_i < q; m_i++) {
            m[m_i] = in.nextInt();
        }
        int[] result = circularArrayRotation(a, m, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
