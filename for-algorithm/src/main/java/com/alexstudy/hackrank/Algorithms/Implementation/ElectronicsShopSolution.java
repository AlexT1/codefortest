package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName ElectronicsShopSolution
 * @Description TODO()
 * @date 2018/3/23 18:11:35
 */
public class ElectronicsShopSolution {
    static int getMoneySpent(int[] keyboards, int[] drives, int s){
        // Complete this function
        int result = -1, keySize = keyboards.length , driveSize = drives.length;
        if (keySize == 1 && driveSize == 1) {
            result = keyboards[0]+drives[0];
            if (result > s)
                return -1;
            else
                return result;
        }
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        if (keySize > driveSize) {
            for (int i = keySize - 1; i >= 0; i--) {
                for (int j = 0; j < driveSize; j++) {
                    if (keyboards[i] + drives[j] <= s && keyboards[i] + drives[j] > result) {
                        result = keyboards[i] + drives[j];
                    }
                }
            }
        } else {
            for (int i = driveSize - 1; i >= 0; i--) {
                for (int j = 0; j < keySize; j++) {
                    if (drives[i] + keyboards[j] <= s && drives[i] + keyboards[j] > result) {
                        result = drives[i] + keyboards[j];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int s = in.nextInt();
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] keyboards = new int[n];
//        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
//            keyboards[keyboards_i] = in.nextInt();
//        }
//        int[] drives = new int[m];
//        for(int drives_i=0; drives_i < m; drives_i++){
//            drives[drives_i] = in.nextInt();
//        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int[] keyboards = {3,1};
        int[] drives = {5,2,8};
        int s = 10;
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
