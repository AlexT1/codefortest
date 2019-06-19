package com.alexstudy.classload;

import java.util.Scanner;

/**
 * @ClassName Logic
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/6/18
 */
public class Logic {
    public static void main(String args[])
    {
        try {
            String someClassName = "";
            Scanner in = new Scanner(System.in);
            System.out.print("Please class name with package structure");
            someClassName = in.nextLine();
            Class clasz = Class.forName(someClassName);
            Object obj = clasz.newInstance();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
