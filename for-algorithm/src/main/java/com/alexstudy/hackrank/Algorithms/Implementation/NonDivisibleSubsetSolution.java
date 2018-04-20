package com.alexstudy.hackrank.Algorithms.Implementation;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author AlexTong
 * @ClassName NonDivisibleSubsetSolution
 * @Description TODO()
 * @date 2018/4/19 16:38:37
 */
public class NonDivisibleSubsetSolution {
    /*
    * Complete the nonDivisibleSubset function below.
    */
//    The first line contains 2 space-separated integers, n and k, the number of values in S and the non factor.
//    The second line contains n space-separated integers describing S[i], the unique values of the set.
    static int nonDivisibleSubset(int k, int[] S) {
        /*
         * Write your code here.
         */
        List<Integer> in_arr = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> max = new ArrayList<Integer>();
        List<Integer> mix = new ArrayList<Integer>();
        Map<Integer,Integer> count =  new HashMap<Integer, Integer>();
        Arrays.sort(S);
        max.add(S[0]);
        max.add(-1);
        for (int i = 0; i < S.length; i++) {
            if (S[i] % k != 0) {
                map.put(S[i], (S[i] % k));
                in_arr.add(S[i]);
                if (count.containsKey((S[i] % k))) {
                    count.put((S[i] % k),count.get((S[i] % k)) +1);
                } else {
                    count.put((S[i] % k),1);
                }
            }
            if (max.get(1) < S[i] % k) {
                max.set(0, S[i]);
                max.set(1, S[i] % k);
            }

        }

        //tree map to array list
        //List<Integer> min_arr = new ArrayList<Integer>(tree_map.values());
//        Object[] key_arrays =  tree_map.keySet().toArray();
//        Object[] value_arrays = tree_map.values().toArray();

        //slow
//        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return  o2.getValue().compareTo(o1.getValue());
//            }
//        });
        Collection<Integer> col = map.values();
        int index = k % 2 == 0 ? k / 2 : k / 2 + (k % 2);
        while (max.get(1) >= index) {
            int temp = Math.abs(k - max.get(1));
            if (map.containsValue(temp) && map.containsValue(max.get(1)) ) {
                if (count.get(max.get(1)) > count.get(temp)) {
                    col.removeAll(max);
                } else {
                    mix.add(map.get(temp));
                    mix.add(temp);
                    col.removeAll(mix);
                }
            }
            max.set(1, max.get(1).intValue() - 1);
        }



        return map.size() - (map.size() - col.size());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String currentDate = df.format(new Date());
//        try {
//
//            Date before = df.parse("2018-04-18");
//            System.out.println(currentDate +  "  before :" + before + "  format :" + df.format(before));
//            System.out.println(df.format(before).compareTo(currentDate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0].trim());
//
//        int k = Integer.parseInt(nk[1].trim());
//
//        int[] S = new int[n];
//
//        String[] SItems = scanner.nextLine().split(" ");
//
//        for (int SItr = 0; SItr < n; SItr++) {
//            int SItem = Integer.parseInt(SItems[SItr].trim());
//            S[SItr] = SItem;
//        }
//
//        int result = nonDivisibleSubset(k, S);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0].trim());
        int k = Integer.parseInt(nk[1].trim());
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = scanner.nextInt();
        }
        int result = nonDivisibleSubset(k,arr);

        System.out.print(result);

        System.out.println("");
    }
}
//13 11
//        582740017 954896345 590538156 298333230 859747706 155195851 331503493 799588305 164222042 563356693 80522822 432354938 652248359
//11