package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.*;

/**
 * Created by Alex on 2018/4/18.
 */
public class LibraryFineSolution {
//    The first line contains 3 space-separated integers denoting the respective day, month, and year on which the book was returned.
//    The second line contains 3 space-separated integers denoting the respective day, month, and year on which the book was due to be returned.
    //constraints   1 <= D <= 31
    // 1<= M <= 12  1 <= Y <= 3000
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Complete this function
        int fixed = 10000, day = 15, month = 500;
//        List<Integer> month_list = new ArrayList<Integer>();
//        Integer[] month_array = {1,3,5,7,8,9,11};
//        month_list = Arrays.asList(month_array);
        if (y1 > y2) {
            return fixed;
        }
        if (y1 == y2){
            if (m1 < m2 || m1 == m2 && (d1 < d2 || d1 == d2)) {
                return 0;
            }
            if (m1 == m2 && d1 > d2) {
                return day * (d1 - d2);
            }
            if (m1 > m2) {
                return month * (m1 - m2);
//                if (month_list.contains(m2)) {
//                    return  month * (m1-m2-1) + day * (d1 + 31 - d2);
//                } else {
//                    if (m2 != 2) {
//                        return  month * (m1-m2-1) + day * (d1 + 30 - d2);
//                    } else {
//                        if ((y2%4==0 && y2%100!=0) || (y2%400==0)) {
//                            return month * (m1 - m2 - 1) + day * (d1 + 29 - d2);
//                        } else {
//                            return month * (m1 - m2 - 1) + day * (d1 + 28 - d2);
//                        }
//                    }
//                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }
}
