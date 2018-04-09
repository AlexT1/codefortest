package com.alexstudy.hackrank.Algorithms.Implementation;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName TheHurdleRaceSolution
 * @Description TODO()
 * @date 2018/4/9 14:36:04
 */
public class TheHurdleRaceSolution {
    static int hurdleRace(int k, int[] height) {
        // Complete this function
        List heightList = Arrays.asList(ArrayUtils.toObject(height));
        Object max = Collections.max(heightList);
        if (k > Integer.valueOf(max.toString())) {
            return 0;
        } else {
            return (Integer.valueOf(max.toString()) - k);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int height_i = 0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        int result = hurdleRace(k, height);
        System.out.println(result);
        in.close();
    }
}
