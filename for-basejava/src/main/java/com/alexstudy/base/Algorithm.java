package com.alexstudy.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author AlexTong
 * @ClassName Algorithm
 * @Description TODO()
 * @date 2018/8/21 10:48:14
 */
public final class Algorithm {
    //for question 3
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //for question 8, answer for mine at parser class findMax method.
    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end) {

        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }

    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for (T elem : c)
            if (p.testOddInteger(elem))
                ++count;
        return count;
    }

    public static <T> int countPn(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for (T elem : c)
            if (p.testPrimeNumber(elem))
                ++count;
        return count;
    }

    public static <T> int countPd(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for (T elem : c)
            if (p.testPalindromes(elem))
                ++count;
        return count;
    }

    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicatelast<T> p) {
        for (; begin < end; ++begin)
            if (p.test(list.get(begin)))
                return begin;
        return -1;
    }
    // x > 0 and y > 0
    public static int gcd(int x, int y) {
        for (int r; (r = x % y) != 0; x = y, y = r) { }  // do not understand clearly
        return y;
    }
}

interface UnaryPredicatelast<T> {
    public boolean test(T obj);
}
class RelativelyPrimePredicate implements UnaryPredicatelast<Integer> {
    public RelativelyPrimePredicate(Collection<Integer> c) {
        this.c = c;
    }

    public boolean test(Integer x) {
        for (Integer i : c)
            if (Algorithm.gcd(x, i) != 1)
                return false;

        return c.size() > 0;
    }

    private Collection<Integer> c;
}

interface UnaryPredicate<T> {
    public boolean testOddInteger(T obj);
    public boolean testPrimeNumber(T obj);
    public boolean testPalindromes(T obj);

}

class OddPredicate implements UnaryPredicate<Integer> {
    public boolean testOddInteger(Integer i) { return i % 2 != 0; }
    public boolean testPrimeNumber(Integer i) {
        return (i % 2 != 0 && i % 3 != 0) || i == 1;
    }
    public boolean testPalindromes(Integer i) {
        char[]  chars= String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int c = chars.length - 1; c >= 0; c-- ) {
            sb.append(chars[c]);
        }
        //return Objects.equals(i, Integer.valueOf(sb.toString()));  //is ok, 414 return true

        //return i == Integer.valueOf(sb.toString()); // when 414, return false
        return i.equals(Integer.valueOf(sb.toString())); // is ok
    }
}

class Test {
    public static void main(String[] args) {
        Collection<Integer> ci = Arrays.asList(1, 2, 3, 4);
        int count = Algorithm.countIf(ci, new OddPredicate());
        System.out.println("Number of odd integers = " + count);
        count = Algorithm.countPn(ci, new OddPredicate());
        System.out.println("Number of prime numbers =" + count);
        Collection<Integer> cd = Arrays.asList(121, 213, 321, 414);
        count = Algorithm.countPd(cd, new OddPredicate());
        System.out.println("Number of palindromes =" + count);
    }
}
class TestLast {
    public static void main(String[] args) throws Exception {
        List<Integer> li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
        UnaryPredicatelast<Integer> p = new RelativelyPrimePredicate(c);

        int i = Algorithm.findFirst(li, 0, li.size(), p);

        if (i != -1) {
            System.out.print(li.get(i) + " is relatively prime to ");
            for (Integer k : c)
                System.out.print(k + " ");
            System.out.println();
        }
    }
}