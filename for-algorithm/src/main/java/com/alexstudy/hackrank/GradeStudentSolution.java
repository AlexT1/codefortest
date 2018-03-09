package com.alexstudy.hackrank;

import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName gradestudent
 * @Description TODO()
 * @date 2018/3/8 10:58:59
 */
public class GradeStudentSolution {
    static int[] solve(int[] grades){
        // Complete this function
        int[] result= new int[grades.length];
        for (int i=0; i < grades.length; i++){
            if (grades[i] >= 38 && (5 - (grades[i]%5)) < 3){
                result[i] = grades[i] + (5 - (grades[i]%5));
            } else if(grades[i] > 0) {
                result[i] = grades[i];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();

        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");

    }
}