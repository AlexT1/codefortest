package com.alexstudy.base;


/**
 * @ClassName PassPrimitiveByValue
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/4 17:36:24
 */
public class PassPrimitiveByValue {
    public static void main(String[] args) {

        int x = 3;

        // invoke passMethod() with
        // x as argument
       passMethod(x);
       Circle circle = new Circle(0,0);
        System.out.println(circle.getX() + " Y :" + circle.getY());
        moveCircle(circle, 23, 56);
        System.out.println(circle.getX() + " Y :" + circle.getY());
        // print x to see if its
        // value has changed
        System.out.println("After invoking passMethod, x = " + x);

    }

    // change parameter in passMethod()
    public static void passMethod(int p) {
        p = 10;
    }

    public static void moveCircle(Circle circle, int deltaX, int deltaY) {
        // code to move origin of circle to x+deltaX, y+deltaY
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        // code to assign a new reference to circle
        circle = new Circle(0, 0);
    }
}
