package com.alexstudy.hackrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName BreakingTheRecordsSolution
 * @Description TODO()
 * @date 2018/3/20 14:06:36
 */
public class BreakingTheRecordsSolution {
    /*
    * Complete the breakingRecords function below.
    */
    static int[] breakingRecords(int[] score) {
        /*
         * Write your code here.
         */
        int[] result = new int[2];
        int max,min,maxCount=0,minCount=0;
        max = min = score[0];
        for(int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
                maxCount++;
            }
            if (min > score[i]) {
                min = score[i];
                minCount++;
            }
        }
        result[0] = maxCount;
        result[1] = minCount;
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int n = Integer.parseInt(scan.nextLine().trim());
//
//        int[] score = new int[n];
//
//        String[] scoreItems = scan.nextLine().split(" ");
//
//        for (int scoreItr = 0; scoreItr < n; scoreItr++) {
//            int scoreItem = Integer.parseInt(scoreItems[scoreItr].trim());
//            score[scoreItr] = scoreItem;
//        }
        int[] score = {10,5,20,20,4,5,2,25,1};
        int[] result = breakingRecords(score);
        System.out.println(result[0] + "  " + result[1]);
//        for (int resultItr = 0; resultItr < result.length; resultItr++) {
//            bw.write(String.valueOf(result[resultItr]));
//
//            if (resultItr != result.length - 1) {
//                bw.write(" ");
//            }
//        }
//
//        bw.newLine();
//
//        bw.close();
    }
}
