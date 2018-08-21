package com.alexstudy.util;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author AlexTong
 * @ClassName CollectionTest
 * @Description TODO()
 * @date 2018/6/14 14:30:09
 */
public class CollectionTest {
    public static void main(String[] args){
        BigDecimal big1 = new BigDecimal(59.85).setScale(2,BigDecimal.ROUND_DOWN);
        BigDecimal big2 = new BigDecimal(2000).setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println(big1.compareTo(big2));
        System.out.println(big1.compareTo(big2) > 0 ? big2 : big1);
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Map<String,Integer> map3 = new HashMap<>();
        map3.put("rank",5);
        map3.put("code",1002);
        map2.put("rank",2);
        map2.put("code",1003);
        map1.put("rank",3);
        map1.put("code",1002);
        List<Map<String,Integer>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        for(Map<String,Integer> map : list){
            System.out.println("before ============ " + map.get("rank") + "   code :" + map.get("code"));
        }
        Collections.sort(list, new Comparator<Map<String,Integer>>() {
            @Override
            public int compare(Map<String,Integer> o1,Map<String,Integer> o2){
                int period1 = o1.get("code");
                int period2 = o2.get("code");;
                int rank1 = o1.get("rank");
                int rank2 = o2.get("rank");
                return (period1*100 + rank1) - (period2*100 + rank2);
            }
        });
        for(Map<String,Integer> map : list){
            System.out.println("after ------------------ " + map.get("rank") + "   code :" + map.get("code"));
        }
    }
}
