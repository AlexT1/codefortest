package com.alexstudy.hackrank.Algorithms.Implementation;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName ExtraFactorialsSolution
 * @Description TODO()
 * @date 2018/4/16 13:50:55
 */
public class ExtraFactorialsSolution {
    static void extraLongFactorials(int n) {
        // Complete this function
        BigInteger result = new BigInteger("1");
        for (int i = 1; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i+1));
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
