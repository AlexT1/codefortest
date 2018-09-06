package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName MultiDimArrayDemo
 * @Description TODO()
 * @date 2018/9/3 17:43:08
 */
public class MultiDimArrayDemo {
    public static void main(String[] args) {
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
    }
}
