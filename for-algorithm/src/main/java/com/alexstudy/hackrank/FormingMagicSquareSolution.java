package com.alexstudy.hackrank;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName FormingMagicSquareSolution
 * @Description TODO()
 * @date 2018/3/26 15:23:46
 */
public class FormingMagicSquareSolution {
    static int formingMagicSquare(int[][] s) {
        // Complete this function
        int result = 0, target = 15, temp = 0, tempIndexi = 0, tempIndexj = 0, tempDvalue = 0, sumCost = 0,
            rightDiagonal = 0,leftDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            result = s[i][0] + s[i][1] + s[i][2];
            tempDvalue = Math.abs(target - result);
            if (tempDvalue != 0) {
                for (int j = 0; j < 3; j++) {
                    temp = s[0][j] + s[1][j] + s[2][j];
                    if (temp != target) {
                        tempIndexi = i;
                        tempIndexj = j;
                    }
                }
                if (target - result > 0) {
                    s[i][tempIndexj] = s[tempIndexi][tempIndexj] + tempDvalue;
                } else {
                    s[i][tempIndexj] = s[tempIndexi][tempIndexj] - tempDvalue;
                }
                sumCost = sumCost + tempDvalue;
            }
        }
        leftDiagonal = s[0][0] + s[1][1] + s[2][2];
        rightDiagonal = s[0][2] + s[1][1] + s[2][0];
        if (leftDiagonal != target || rightDiagonal != target) {

        }
        return sumCost;
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
