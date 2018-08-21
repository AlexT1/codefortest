package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName UtilityClass
 * @Description TODO()
 * @date 2018/7/17 10:42:56
 */
//Noninstantiable utility class
public class UtilityClass {
    //Suppress default constructor for noninstantiability
    private UtilityClass(){
        //This constructor will never be invoked
    }
    public static void main(String[] args){
        Long begin =  System.currentTimeMillis();
        System.out.println("Begin :" + System.currentTimeMillis());
        for (int i = 0; i < 30; i++) {
            System.out.println("Loop begin : " + System.currentTimeMillis());
            //String a = new String("silly");
            String a ="No longer silly";
            System.out.println("Loop end : " + System.currentTimeMillis());
        }
        System.out.println(System.currentTimeMillis()-begin);
    }
}
