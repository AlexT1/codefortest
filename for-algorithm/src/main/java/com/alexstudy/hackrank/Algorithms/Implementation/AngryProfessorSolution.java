package com.alexstudy.hackrank.Algorithms.Implementation;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName AngryProfessorSolution
 * @Description TODO()
 * @date 2018/4/9 14:34:12
 */
public class AngryProfessorSolution {
    static String angryProfessor(int k, int[] a) {
        // Complete this function
        Arrays.sort(a);
        List<Integer> arrayList = Arrays.asList(ArrayUtils.toObject(a));
        if (arrayList.get(k-1).compareTo(0) <= 0) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = angryProfessor(k, a);
            System.out.println(result);
        }
        in.close();
    }
}
