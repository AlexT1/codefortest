package main.java.com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * Created by Alex on 2018/4/12.
 */
public class RevisitedSolution {
    static int jumpingOnClouds(int[] c, int k) {
        // Complete this function
        int energy = 100, index=0, size = c.length;
        do {
            if (c[(index + k) % size] == 1) {
                energy = energy - 2;
            }
            energy--;
            index = (index + k) % size;
        } while (index > 0);

        return energy;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
        in.close();
    }
}
