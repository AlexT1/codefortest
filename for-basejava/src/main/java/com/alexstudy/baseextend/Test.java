package com.alexstudy.baseextend;

/**
 * @ClassName Test
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/6/24
 */
public class Test {
    int mangoes = 10;                                 // it is variable
    public Test()                                     //  it is constructor
    {
        System.out.println("Constructor is called");
    }
    public void show()                                //  it is method
    {
        System.out.println("Method is called");
    }
    public static void main(String args[])
    {
        Test t1 = new Test();                           // implicitly, constructor is called
      
        System.out.println("No. of mangoes: " + t1.mangoes);  // variable is called
        t1.show();  // method is called
        System.out.println("abc\ndef");    // abc and def are given in two lines

        System.out.println("ab\bcd");      // prints acd
        System.out.println("ab \bcd");     // prints abcd, the space before \b is gone
        System.out.println("abcdefghij");  //
        System.out.println("ab\tcd");      // prints ab   cd, gives 3 spaces between ab and cd

        System.out.println("a\"bc\"d");    // prints a"bc"d

        System.out.println("a\'bc\'d");    // prints a'bc'd
    }
}
