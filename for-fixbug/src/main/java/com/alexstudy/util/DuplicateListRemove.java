package com.alexstudy.util;

import java.util.*;

/**
 * @author AlexTong
 * @ClassName DuplicateListRemove
 * @Description TODO()
 * @date 2018/6/6 10:21:21
 */
public class DuplicateListRemove {
    public static void pastLeep1(List<String> list){
        System.out.println("list = [" + list.toString() + "]");
        List<String> listNew=new ArrayList<>();
        Set set=new HashSet();
        for (String str:list) {
            if(set.add(str)){
                listNew.add(str);
            }
        }
        System.out.println("listNew = [" + listNew.toString() + "]");
    }

    //遍历后判断赋给另一个list集合
    public static void pastLeep2(List<String> list){
        System.out.println("list = [" + list.toString() + "]");
        List<String> listNew=new ArrayList<>();
        for (String str:list) {
            if(!listNew.contains(str)){
                listNew.add(str);
            }
        }
        System.out.println("listNew = [" + listNew.toString() + "]");
    }

    //set去重
    public static void pastLeep3(List<String> list){
        System.out.println("list = [" + list + "]");
        Set set = new HashSet();
        List<String> listNew=new ArrayList<>();
        set.addAll(list);
        listNew.addAll(set);
        System.out.println("listNew = [" + listNew + "]");
    }

    //set去重（缩减为一行）
    public static void pastLeep4(List<String> list){
        System.out.println("list = [" + list + "]");
        List<String> listNew=new ArrayList<>(new HashSet(list));
        System.out.println("listNew = [" + listNew + "]");
    }

    //去重并按自然顺序排序
    public static void pastLeep5(List<String> list){
        System.out.println("list = [" + list + "]");
        List<String> listNew=new ArrayList<>(new TreeSet<String>(list));
        System.out.println("listNew = [" + listNew + "]");
    }
}
