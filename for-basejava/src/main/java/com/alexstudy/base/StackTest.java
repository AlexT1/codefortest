package com.alexstudy.base;

import java.util.Date;
import java.util.EmptyStackException;

/**
 * @author AlexTong
 * @ClassName StackTest
 * @Description TODO()
 * @date 2018/7/17 13:51:16
 */
//Can you spot the "memory leak"?
public class StackTest {
    private Object[] elements;
    private int size = 0;

    public StackTest(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        return elements[--size];
//    }
    //Optimize version
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }


    /**
     * Ensure space for at least one more element, roughly doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[2 * elements.length + 1];
            System.arraycopy(oldElements, 0, elements,0,size);
        }
    }

    public static void main(String[] args){
        Long begin = System.currentTimeMillis();
        System.out.println(begin);
        StackTest test = new StackTest(300);
        Person person = new Person(new Date());
        test.push(person);
        test.pop();
        System.out.println(System.currentTimeMillis() - begin);

    }
}
