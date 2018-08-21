package com.alexstudy.reflect;

import java.math.BigInteger;

import static java.lang.Boolean.TRUE;

/**
 * @author AlexTong
 * @ClassName BooleanTestForBasic
 * @Description TODO()
 * @date 2018/7/11 15:34:13
 */
public class BooleanTestForBasic {
    public static String replaceContractNoPrefix(String contractNo) {
        String reduceString = contractNo;
        if (reduceString != null) {
            if (contractNo.contains("PL")) {
                reduceString = contractNo.replace("PL", "C");
            }
            if (contractNo.contains("TSPL")) {
                reduceString = contractNo.replace("TSPL", "C");
            }
        }
        return reduceString;
    }

    public static void main(String[] args){
        Boolean s = false;
        Boolean te = Boolean.TRUE;
        System.out.println(!TRUE.equals(te));
        String s1 = "PLcwefwe";
        String s2 = "TSPL124";
        System.out.println(replaceContractNoPrefix(s1));
        System.out.println(replaceContractNoPrefix(s2));
        String s3 = "";
        System.out.println(replaceContractNoPrefix(s3));
    }
}
