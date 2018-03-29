package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName BirthdayChocolateSolution
 * @Description TODO()
 * @date 2018/3/20 15:10:12
 */
public class BirthdayChocolateSolution {
    static int solve(int n, int[] s, int d, int m){
        // Complete this function
        int count = 0,temp;
        if (n == 1 && m==1) {
          if (d==s[0]) {
              count = 1;
              return count;
          }
        }

        for(int i = 0; i < n; i++) {
            int index = i+m;
            if (index < n) {
                temp = recursiveMethod(i,index, d,m,s);
            } else {
                temp = recursiveMethod(i,n,d,m,s);
            }
            if (temp != 0) {
                count++;
            }
        }
        return count;
    }

    public static int recursiveMethod(int a,int b, int des, int m, int[] s){
        int temp = 0, count = 0;
        for (int i = a; i < b; i++) {
            temp = temp + s[i];
        }
        if (temp == des) {
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] s = new int[n];
//        for(int s_i=0; s_i < n; s_i++){
//            s[s_i] = in.nextInt();
//        }
//        int d = in.nextInt();
//        int m = in.nextInt();
        int m,d,n;
//        int[] s = {1,1,1,1,1,1};
        int[] s = {2,3,4,4,2 ,1, 2, 5 ,3 ,4 ,4 ,3 ,4 ,1, 3, 5 ,4 ,5, 3, 1, 1 ,5
                ,4 ,3 ,5 ,3 ,5 ,3 ,4 ,4, 2, 4 ,5 ,2 ,3 ,2 ,5 ,3, 4 ,2, 4 ,3, 3 ,
                4, 3, 5 ,2 ,5 ,1, 3, 1, 4 ,2 ,2, 4 ,3, 3, 3 ,3 ,4 ,1, 1 ,4, 3 ,
                1 ,5 ,2 ,5 ,1 ,3 ,5 ,4 ,3 ,3, 1, 5, 3, 3, 3, 4 ,5, 2};
        n=82;m=8;d=26;
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
