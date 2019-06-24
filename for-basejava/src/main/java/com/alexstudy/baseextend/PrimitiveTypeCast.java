package com.alexstudy.baseextend;


/**
 * @ClassName PrimitiveTypeCast
 * @Description
 * @Author AlexTong
 * @Date 2019/4/13
 */
public class PrimitiveTypeCast {
    public void show(int x) {
        System.out.println("In int" + x);
    }

    public void show(String s) {
        System.out.println("In String" + s);
    }

    public void show(byte b) {
        System.out.println("In byte" + b);
    }

    public static void main(String[] args) {
        byte a = 25;
        PrimitiveTypeCast obj = new PrimitiveTypeCast();
        obj.show(a); // it will go to
        // byte argument
        obj.show("hello"); // String
        obj.show(250); // Int
        obj.show('A'); // Since char is
        // not available, so the datatype
        // higher than char in terms of
        // range is int.
        obj.show("A"); // String
//        obj.show(7.5); // since float datatype
// is not available and so it's higher
// datatype, so at this step their
// will be an error.

    }
}
