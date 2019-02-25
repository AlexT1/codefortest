package com.alexstudy.base;

/**
 * @ClassName Cat
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/27
 */
public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
        Cat.testClassMethod();
    }
}
