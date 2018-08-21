package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName Foo
 * @Description TODO()
 * @date 2018/7/17 16:25:23
 */
// Finalizer Guardian idiom
public class Foo {
    //Sole purpose of this object is to finalize outer Foo object
    private final Object finalizerGuardian = new Object() {
        protected void finalize() throws Throwable {
            // Finalize outer Foo object
        }
    };
    //Remainder omitted
}
