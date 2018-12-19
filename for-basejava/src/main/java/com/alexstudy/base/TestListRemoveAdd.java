package com.alexstudy.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestListRemoveAdd
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/10/8 15:33:19
 * @Copyright 通善金融
 */
public class TestListRemoveAdd {
    public static void main(String[] args){
        Bicycle b1 = new Bicycle(1,1,1);
        Bicycle b2 = new Bicycle(2,2,2);
        Bicycle b3 = new Bicycle(2,2,3);
        List<Bicycle> allList = new ArrayList<Bicycle>();
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        if (!idList.contains(2)) {
            idList.add(1);
        }
        allList.add(b1);
        allList.add(b2);
        List<Bicycle> oneList = new ArrayList<Bicycle>();
        oneList.add(b3);
        allList.removeAll(oneList);
        for(Bicycle bi: allList){
            System.out.println("remove :" + bi.gear);
        }
        allList.addAll(oneList);

        for(Bicycle bi: allList){
            System.out.println("add :" + bi.gear);
        }
        allList.addAll(oneList);
        for(Bicycle bi: allList){
            System.out.println("add2 :" + bi.gear);
        }
        System.out.println(idList);
    }
}
