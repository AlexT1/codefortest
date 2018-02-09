package com.alexstudy.reflect;

/**
 * @author AlexTong
 * @ClassName GetClass
 * @Description TODO()
 * @date 2018/2/7 17:58:03
 */
//public class GetClass {
//    public static void main(String[] args) {
//        GetClass c = new GetClass();
//        System.out.println(c.getClass().getName());
//        System.out.println("结果是reflect.GetClass");
//        Demo d = new Demo();
//        System.out.println(d.getClass().getName());
//        System.out.println("结果是reflect.Demo");
//    }
//}
//
//class Demo {
//
//}

public class GetClass {
    public static void main(String[] args) {
        Class<?> demo1=null;
        Class<?> demo2=null;
        Class<?> demo3=null;
        demo1=Demo.class;
        demo2=new Demo().getClass();
        try {
            demo3=Class.forName("com.alexstudy.reflect.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("demo1，2,3的值是class reflect.Demo");
        System.out.println("类名称   "+demo1.getName());
        System.out.println("类名称   "+demo2.getName());
        System.out.println("类名称   "+demo3.getName());
        System.out.println("他们的值都是reflect.Demo");
    }
}
//class Demo{
//
//}