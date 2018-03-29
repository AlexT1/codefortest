package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName DrawingBookSolution
 * @Description TODO()
 * @date 2018/3/22 11:22:02
 */
public class DrawingBookSolution {
    static int solve(int n, int p){
        // Complete this function
        int result = 0, defaultPage=1, pageSize=2, onePage=1,
                firstWay=0, secondWay=0, currentPage=0;
        if ((n-onePage) == p || p==defaultPage || n==p) {
            if((n-onePage)%2 != 0 && p != 1 && n!=p) {
                return onePage;
            }
            return result;
        }
        if ((n-p) > (p-1)) {
            do {
                if (currentPage == 0) {
                    currentPage = defaultPage + pageSize;
                } else {
                    currentPage = currentPage + pageSize;
                }
                firstWay++;
            } while (currentPage < p);
            result = firstWay;
        } else {
            do {

                if (currentPage == 0) {
                    currentPage = n - pageSize;
                } else {
                    currentPage = currentPage - pageSize;
                }
                secondWay++;
            } while (currentPage > p && currentPage-onePage!=p);
            result = secondWay;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        // 18183  18042  70
        //6 5 1
        //5 4 0
        //5 5 0
        System.out.println(result);
    }
}
