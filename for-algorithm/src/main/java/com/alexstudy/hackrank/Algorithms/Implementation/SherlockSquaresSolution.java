package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName SherlockSquaresSolution
 * @Description TODO()
 * @date 2018/4/16 18:19:58
 */
public class SherlockSquaresSolution {
    static int squares(int a, int b) {
        // Complete this function
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int result = squares(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
