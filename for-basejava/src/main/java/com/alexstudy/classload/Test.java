package com.alexstudy.classload;

/**
 * @ClassName Test
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/6/18
 */
public class Test {
    static
    {
        System.out.println("Static block called");
    }
    public Test()
    {
        System.out.println("Inside Test class constructor");
    }
}
