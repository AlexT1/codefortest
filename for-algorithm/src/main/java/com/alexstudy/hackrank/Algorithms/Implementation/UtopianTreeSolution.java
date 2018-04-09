package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName UtopianTreeSolution
 * @Description TODO()
 * @date 2018/4/9 14:31:28
 */
public class UtopianTreeSolution {
    static int utopianTree(int n) {
        // Complete this function
        int height = 1, resultHeight=0, temp = 1;
        do {
            if (temp % 2 == 0) {
                resultHeight = resultHeight + height;
            } else {
                if (n == 0 ) {
                    resultHeight = resultHeight + height;
                } else if (n == 1 || temp == 1) {
                    resultHeight = resultHeight + height * 2;
                } else {
                    resultHeight = resultHeight * 2;
                }
            }
            temp++;
        } while (n >= temp);
        return resultHeight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = utopianTree(n);
            System.out.println(result);
        }
        in.close();
    }
}
