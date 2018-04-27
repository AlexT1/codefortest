package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.*;

/**
 * @author AlexTong
 * @ClassName QueensAttackIISolution
 * @Description TODO()
 * @date 2018/4/26 9:42:54
 */
public class QueensAttackIISolution {
//  The first line contains two space-separated integers describing the respective values of n(the side length of the board) and k(the number of obstacles).
//  The next line contains two space-separated integers describing the respective values of rq and cq, denoting the position of the queen.
//    Each line i of the k subsequent lines contains two space-separated integers describing the respective values of ri and ci, denoting the position of obstacle i.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // Complete this function
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < k; i++){
            list.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for(String s : list){
            if (list.contains(s)) {
                System.out.println(" s :" + s);
            }
        }
        int result = 0;
        if (k != 0) {
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if (i == r_q || j == c_q) {
                        result += n - 1;
                        if (list.contains(i + "," + j)) {
                           result = result - j;
                        }
                    }

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}
