package com.alexstudy.reflect;

import java.lang.reflect.Constructor;

/**
 * @author AlexTong
 * @ClassName Person
 * @Description TODO()
 * @date 2018/2/7 18:05:36
 */
public class Person {
    public Person(){}
    public Person(String name){
        this.name=name;
    }
    public Person(int age){
        this.age=age;
    }
    public Person(String name, int age) {
        this.age=age;
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return "["+this.name+"  "+this.age+"]";
    }
    private String name;
    private int age;
}
