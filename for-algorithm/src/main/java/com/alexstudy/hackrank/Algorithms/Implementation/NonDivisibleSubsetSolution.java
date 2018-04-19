package com.alexstudy.hackrank.Algorithms.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName NonDivisibleSubsetSolution
 * @Description TODO()
 * @date 2018/4/19 16:38:37
 */
public class NonDivisibleSubsetSolution {
    /*
    * Complete the nonDivisibleSubset function below.
    */
//    The first line contains 2 space-separated integers, n and k, the number of values in S and the non factor.
//    The second line contains n space-separated integers describing S[i], the unique values of the set.
    static int nonDivisibleSubset(int k, int[] S) {
        /*
         * Write your code here.
         */
        int result = 0, index = 1;
        Arrays.sort(S);

//        for(int i = 0; i < S.length; i++){
//            for(int j = i+1; j < S.length; j++){
//                if((S[i] + S[j])%k != 0) {
//                    result++;
//                }
//            }
//        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0].trim());
//
//        int k = Integer.parseInt(nk[1].trim());
//
//        int[] S = new int[n];
//
//        String[] SItems = scanner.nextLine().split(" ");
//
//        for (int SItr = 0; SItr < n; SItr++) {
//            int SItem = Integer.parseInt(SItems[SItr].trim());
//            S[SItr] = SItem;
//        }
//
//        int result = nonDivisibleSubset(k, S);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0].trim());
        int k = Integer.parseInt(nk[1].trim());
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = scanner.nextInt();
        }
        int result = nonDivisibleSubset(k,arr);

        System.out.print(result);

        System.out.println("");
    }
}
