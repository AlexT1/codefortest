package com.alexstudy.base;

import java.util.List;

/**
 * @author AlexTong
 * @ClassName WildcardError
 * @Description TODO()
 * @date 2018/8/10 15:05:27
 */
//public class WildcardError {
//
//    void foo(List<?> i) {
//        i.set(0, i.get(0));
//    }
//}
/*In this example, the compiler processes the i input parameter as being of type Object.
    When the foo method invokes List.set(int, E), the compiler is not able to confirm the type of object that is
    being inserted into the list, and an error is produced. When this type of error occurs it typically means that
    the compiler believes that you are assigning the wrong type to a variable. Generics were added to the Java language
    for this reason — to enforce type safety at compile time.
 */

public class WildcardFixed {

    void foo(List<?> i) {
        fooHelper(i);
    }


    // Helper method created so that the wildcard can be captured
    // through type inference.
    //By convention, helper methods are generally named originalMethodNameHelper.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

}