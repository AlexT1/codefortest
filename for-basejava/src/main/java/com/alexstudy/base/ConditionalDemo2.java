package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName ConditionalDemo2
 * @Description TODO()
 * @date 2018/9/4 17:16:40
 */
public class ConditionalDemo2 {
    public static void main(String[] args){
        int value1 = 1;
        int value2 = 2;
        int result;
        boolean someCondition = true;
        result = someCondition ? value1 : value2;

        System.out.println(result);
    }
}
