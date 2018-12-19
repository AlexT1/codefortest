package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName Node
 * @Description TODO()
 * @date 2018/8/13 14:10:48
 */
//MyNode bridge method test
public class Node<T> {
    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

//public class Node<T> {
//    private T data;
//    private Node<T> next;
//
//    public Node(T data, Node<T> next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    public T getData() { return data; }
//    // ...
//}

//Because the type parameter T is unbounded, the Java compiler replaces it with Object:
//public class Node {
//
//    private Object data;
//    private Node next;
//
//    public Node(Object data, Node next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    public Object getData() { return data; }
//    // ...
//}


//In the following example, the generic Node class uses a bounded type parameter:
//public class Node<T extends Comparable<T>> {

//    private T data;
//    private Node<T> next;
//
//    public Node(T data, Node<T> next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    public T getData() { return data; }
//    // ...
//}
//The Java compiler replaces the bounded type parameter T with the first bound class, Comparable:
//public class Node {
//
//    private Comparable data;
//    private Node next;
//
//    public Node(Comparable data, Node next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    public Comparable getData() { return data; }
//    // ...
//}

class Shape { /* ... */ }
class Circle extends Shape {
    /* ... */
    private int X;
    private int Y;
    Circle(int x, int y){
        this.X = x;
        this.Y = y;
    }
    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}
//class Rectangle extends Shape { /* ... */ }
//class Node<T> { /* ... */ }

class TestNode{
    public static void main(String[] args){
//        Node<Circle> nc = new Node<>();
//        Node<Shape>  ns = nc; //Node<Circle>  and Node<Shape> is not same class can not convert

//        public class Node<T> implements Comparable<T> {
//            public int compareTo(T obj) { /* ... */ return 0;}
//            // ...
//        }
//        Node<String> node = new Node<>();
//        Comparable<String> comp = node;
//        System.out.println(comp.getClass().getName());//when node param generic type and implements comparable,
        //  compile ok, but not understand why
    }
}

