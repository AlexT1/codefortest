package com.alexstudy.baseextend;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamFlatMap
 * @Description
 * @Author AlexTong
 * @Date 2019/4/14
 */
public class StreamFlatMap {
    public static void main(String[] args) {
        Integer[][] data = {{1,2},{3,4},{5,6}};
        List<String> list2 = Arrays.asList("green","yellow","blue");
        Arrays.stream(data).flatMap(Arrays::stream)//.filter(num -> num%2 == 1)
                .forEach(s -> System.out.print(s+" "));
        System.out.println(list2.stream().max((s1,s2) -> s1.compareTo(s2)));//.filter(s -> s.endsWith("n")));//.orElse("yellow"));
    }
}
