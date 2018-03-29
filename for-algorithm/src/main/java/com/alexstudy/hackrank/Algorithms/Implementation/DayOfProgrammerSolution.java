package com.alexstudy.hackrank.Algorithms.Implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName DayOfProgrammerSolution
 * @Description TODO()
 * @date 2018/3/21 16:22:03
 */
public class DayOfProgrammerSolution {
    static String solve(int year){
        // Complete this function
//        SimpleDateFormat targetFmt=new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat targetFmt2=new SimpleDateFormat("dd.MM.yyyy");
        int beforeYear=1919, specialYear=1918, specialDay=28, sumDay=0, programmerDay=256;
        boolean leapYear=false;
        String result = null;
        if (year < beforeYear) {
            leapYear = year%4 == 0 ? true:false;
        } else {
            leapYear = (year%400 == 0 || (year%4 == 0 && year%100 != 0)) ? true : false;
        }
        for(int i=1; i < 13; i++) {
           int temp = i;

           if ((temp&=0x1) == 1 || i==8) {
               sumDay = sumDay + 31;
           } else {
               if (i == 2) {
                   if (year == specialYear) {
                       sumDay = sumDay + 15;
                   } else {
                       sumDay = sumDay + (leapYear ? specialDay + 1 : specialDay);
                   }
               } else {
                   sumDay = sumDay + 30;
               }
           }
           if ((programmerDay - sumDay) <= 30) {

               result = (programmerDay - sumDay) +"." + "0" + (i+1) + "."+ year;

//               try {
//                   Date date = targetFmt.parse(temp1);
//
//                   return  targetFmt2.parse(String.valueOf(date)).toString();
//               } catch (ParseException e) {
//                   e.printStackTrace();
//               }
               return result;
           }
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int year = in.nextInt();
        int year = 1918;
        String result = solve(year);
        System.out.println(result);
    }
}
