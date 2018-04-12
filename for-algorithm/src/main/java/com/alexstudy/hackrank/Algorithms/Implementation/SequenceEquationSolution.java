package com.alexstudy.hackrank.Algorithms.Implementation;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author AlexTong
 * @ClassName SequenceEquationSolution
 * @Description TODO()
 * @date 2018/4/12 17:55:43
 */
public class SequenceEquationSolution {
//    The first line contains an integer n, the number of elements in the sequence. 1<= n <=50
//    The second line contains n space-separated integers p[i] where 1 <= i <=n.
    // x is a sequence number from 1 to p.length and x always have a equal element from p
    static int[] permutationEquation(int[] p) {
        // Complete this function
        int[] result = new int[p.length];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < p.length; i++){
            map.put(i+1,p[i]);
        }
        for(int j = 1; j <= p.length; j++){
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if (entry.getValue() == j){
                    result[j-1] = getKeyByValue(map,entry.getKey());
                    break;
                }
            }
        }
        return result;
    }
    public static Integer getKeyByValue(Map map, Object value) {
        Integer  keys= 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object obj = entry.getValue();
            if (obj != null && obj.equals(value)) {
                keys= (Integer) entry.getKey();
            }

        }
        return keys;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
