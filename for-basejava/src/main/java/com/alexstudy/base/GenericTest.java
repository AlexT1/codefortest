package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName GenericTest
 * @Description TODO()
 * @date 2018/7/26 17:06:00
 */
//public class GenericTest {
//    private Object object;
//
//    public void set(Object object) { this.object = object; }
//    public Object get() { return object; }
//}

/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class GenericTest<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
//class  Test{
//    public static void main(String[] args){
//        GenericTest<Integer> genericTest = new GenericTest<Integer>();
//        genericTest.set(Integer.MAX_VALUE);
//        GenericTest<String> genericTest1 = new GenericTest<String>();
//        System.out.println(genericTest.get());
//        genericTest1.set("hellos");
//        System.out.println(genericTest1.get());
//        GenericTest<String> box = new GenericTest();
//        GenericTest rawBox = box;
//        rawBox.set(8);//  warning: unchecked invocation to set(T)
//        System.out.println(rawBox.get());

//        GenericTest rawBox = new GenericTest();// rawBox is a raw type of Box<T>
//        GenericTest<Integer> intBox = rawBox;// warning: unchecked conversion
//        // Unchecked assignment: 'com.alexstudy.base.GenericTest' to 'com.alexstudy.base.GenericTest<java.lang.Integer>'
//        intBox.set(8);
//        System.out.println(intBox.get());

//        The complete syntax for invoking this method would be:
//        PairClass<Integer, String> p1 = new PairClass<>(1, "apple");
//        PairClass<Integer, String> p2 = new PairClass<>(2, "pear");
//        boolean same = UtilPairClass.<Integer, String>compare(p1, p2);
//        System.out.println(same);


//        The type has been explicitly provided, as shown in bold. Generally, this can be left out and the compiler will infer the type that is needed:
//        PairClass<Integer, String> p1 = new PairClass<>(1, "apple");
//        PairClass<Integer, String> p2 = new PairClass<>(2, "pear");
//        boolean same = UtilPairClass.compare(p1, p2);
//        System.out.println(same);
//    }
//}

