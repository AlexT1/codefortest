package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName ContinueWithLabelDemo
 * @Description TODO()
 * @date 2018/9/11 14:46:07
 */
public class ContinueWithLabelDemo {
    public static void main(String[] args) {
        int aNumber = 3;
        if (aNumber >= 0) {
            if (aNumber == 0) {
                System.out.println("first string");
            } else {
                System.out.println("second string");
            }
        }
        System.out.println("third string");

        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() -
                substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break test;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }
}
