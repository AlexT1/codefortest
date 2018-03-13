package com.alexstudy.other;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName CompareMapIterator
 * @Description TODO()
 * @date 2018/3/13 9:35:11
 */
public class CompareMapIterator {

    public void iteratorMap1(HashMap<Integer, Integer> map){
        //    方式一 这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用。
        HashMap<Integer,Integer> map1 = map;
        for (Map.Entry<Integer, Integer> entry: map1.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
    public void iteratorMap2(HashMap<Integer, Integer> map){
//        方法二 在for-each循环中遍历keys或values。
//
//    如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet。

    HashMap<Integer, Integer> map2 = map;
//        遍历map中的键
    for (Integer key : map2.keySet()) {
        System.out.println("Key = " + key);
    }
        //遍历map中的值
    for (Integer value : map2.values()) {
        System.out.println("Value = " + value);
    }
//    该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
    }

    public void iteratorMap3(HashMap<Integer, Integer> map){
//    方法三使用Iterator遍历
//
//    使用泛型：
    HashMap<Integer, Integer> map3 = map;
    Iterator<Map.Entry<Integer, Integer>> entries3 = map3.entrySet().iterator();
    while (entries3.hasNext()) {
        Map.Entry<Integer, Integer> entry = entries3.next();
        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }
//    不使用泛型：
    HashMap map4 = map;
    Iterator entries4 = map4.entrySet().iterator();
    while (entries4.hasNext()) {
        Map.Entry entry = (Map.Entry) entries4.next();
        Integer key = (Integer)entry.getKey();
        Integer value = (Integer)entry.getValue();
        System.out.println("Key = " + key + ", Value = " + value);
    }
//    你也可以在keySet和values上应用同样的方法。
//
//    该种方式看起来冗余却有其优点所在。首先，在老版本java中这是惟一遍历map的方式。另一个好处是，你可以在遍历时调用iterator.remove()来删除entries，另两个方法则不能。根据javadoc的说明，如果在for-each遍历中尝试使用此方法，结果是不可预测的。
//
//    从性能方面看，该方法类同于for-each遍历（即方法二）的性能。
    }

    public void iteratorMap4(HashMap<Integer, Integer> map){
        //    方法四、通过键找值遍历（效率低）
        HashMap<Integer, Integer> map5 = map;
        for (Integer key : map5.keySet()) {
            Integer value = map5.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }
        // 作为方法一的替代，这个代码看上去更加干净；但实际上它相当慢且无效率。
        // 因为从键取值是耗时的操作（与方法一相比，在不同的Map实现中该方法慢了20%~200%）。
        // 如果你安装了FindBugs，它会做出检查并警告你关于哪些是低效率的遍历。所以尽量避免使用。
    }

//总结
//如果仅需要键(keys)或值(values)使用方法二。如果你使用的语言版本低于java 5，或是打算在遍历时删除entries，必须使用方法三。否则使用方法一(键值都要)。
}
