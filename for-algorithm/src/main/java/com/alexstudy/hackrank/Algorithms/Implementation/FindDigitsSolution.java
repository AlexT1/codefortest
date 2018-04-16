package main.java.com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alex on 2018/4/12.
 */
public class FindDigitsSolution {
//    The first line is an integer,t , indicating the number of test cases.
//    The t subsequent lines each contain an integer, n.
    static int findDigits(int n) {
        // Complete this function
        List<Integer> num = new ArrayList<Integer>();
        int res = 0, temp = n;
        while(temp != 0){
            res = temp % 10;
            if (res != 0 && n%res == 0) {
                num.add(res);
            }
            temp = temp /10;

        }
        return num.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        in.close();
    }
}
