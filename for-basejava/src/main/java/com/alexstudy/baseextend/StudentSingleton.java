package com.alexstudy.baseextend;

/**
 * @ClassName StudentSingleton
 * @Description
 * @Author AlexTong
 * @Date 2019/4/13
 */
public class StudentSingleton {
    private int marks;                 // assigned with default 0
    private static StudentSingleton std;        // assigned with default null
//Observe, the way of developing a singleton, declare the constructor private so that outside classes cannot
// create Student object directly and must go through a method call only to create.
    private StudentSingleton() {
        // some code if required
    }

    public static synchronized StudentSingleton getMe() {
        if (std == null) {
            std = new StudentSingleton();
        }
        return std;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Not allowed on this singleton object");
    }

    public static void main(String args[]) {
        StudentSingleton std1 = getMe();
        StudentSingleton std2 = getMe();

        std1.marks = 50;
        std2.marks = 60;
        System.out.println("std1 marks when std2 changes: " + std1.marks);   // 60

        std1.marks = 70;
        System.out.println("std2 marks when std1 changes: " + std2.marks);    // 70

        System.out.println("\nstd1 hash code: " + std1.hashCode());
        System.out.println("std2 hash code: " + std2.hashCode());
    }
}
