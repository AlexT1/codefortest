package com.alexstudy.hackrank;

import java.util.*;

/**
 * @author AlexTong
 * @ClassName FormingMagicSquareSolution
 * @Description TODO()
 * @date 2018/3/26 15:23:46
 */
public class FormingMagicSquareSolution {
    static int formingMagicSquare(int[][] s) {
        // Complete this function
//        int[][][] possiblePermutations = {
//                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1
//
//                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2
//
//                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3
//
//                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4
//
//                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5
//
//                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6
//
//                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7
//
//                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
//        };
        int[] thirdLine = {1,2,3,4,6,7,8,9};
        int[] secondLine = {1,3,5,7,9};
        int sumCost = 0, target = 15, tempDvalue = 0, tempRvalue = 0, minValue = 0;
        List<Integer> firstLine = new ArrayList<Integer>();
        List<Integer> centralLine = new ArrayList<Integer>();
        int centralSum = s[1][0] + s[1][1] + s[1][2] ;
        Map<Integer,Integer> map = new HashMap<>();
        for (int n = 1; n < 10; n++) {
            firstLine.add(n);
            if (n%2 != 0) {
                centralLine.add(n);
            }
        }
        if (s[1][1] != 5) {
            tempRvalue = 5 - s[1][1];
            tempDvalue = Math.abs(5 - s[1][1]);
            s[1][1] = s[1][1] + tempRvalue;
            sumCost = sumCost + tempDvalue;
        }
        int oldValue = 0;
        for (int j = 1; j < 10; j= j+2) {
            if (j!=5){
                oldValue = s[1][1];
                int now =  oldValue - j;
                if (now < minValue) {
                    minValue = now;
                    s[1][1] = j;
                }
            }
        }
        switch (s[1][1]) {
            case 1:
                break;
            case 3:
                break;
            case 7:
                break;
            case 9:
                break;
        }
        return  sumCost;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[][] s = new int[3][3];
//        for(int s_i = 0; s_i < 3; s_i++){
//            for(int s_j = 0; s_j < 3; s_j++){
//                s[s_i][s_j] = in.nextInt();
//            }
//        }
//        int[] single = {4,8,2,4,5,7,6,1,6};
        int[] single = {6, 4, 6, 9, 9, 3, 9, 9, 7};
        int[][] s = new int[3][3];
        int middle = 0;
        for (int s_i = 0; s_i < 3; s_i++) {
            for (int s_j = 0; s_j < 3; s_j++) {
                s[s_i][s_j] = single[middle + s_j];
            }
            middle = middle + 3;
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
//        in.close();
    }
}
