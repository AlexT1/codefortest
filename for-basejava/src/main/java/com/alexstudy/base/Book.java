package com.alexstudy.base;

/**
 * @ClassName Book
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/1/3
 */
public class Book {
    private String ISBN;
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String isbn){
        this.ISBN = isbn;
    }

//    public boolean equals(Object obj) {
//        if (obj instanceof Book)
//            return ISBN.equals(((Book) obj).getISBN());
//        else
//            return false;
//    }

   public void printClassName(Object obj) {
        System.out.println("The object's" + " class is " +
                obj.getClass().getSimpleName());
       System.out.println("The object's" + " Superclass is " +
               obj.getClass().getSuperclass());
       System.out.println("The object's" + " getInterfaces is " +
               obj.getClass().getInterfaces().length);
       System.out.println("The object's" + " getFields is " +
               obj.getClass().getFields().length);
    }

    public static void main(String[] args){
        // Swing Tutorial, 2nd edition
        Book firstBook  = new Book("0201914670");
        Book secondBook = new Book("0201914670");
        firstBook.printClassName(secondBook);
        if (firstBook.equals(secondBook)) {
            System.out.println("objects are equal");
        } else {
            // if don't rewrite the equals method print not equal info, cause default equals is compare primitive data type, not object,
            // object is compare the reference is equal so is return false and print not equal, but object contain is equal.
            System.out.println("objects are not equal");
        }
    }
}
