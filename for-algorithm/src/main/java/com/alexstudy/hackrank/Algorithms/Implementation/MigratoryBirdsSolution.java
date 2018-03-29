package com.alexstudy.hackrank.Algorithms.Implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author AlexTong
 * @ClassName MigratoryBirdsSolution
 * @Description TODO()
 * @date 2018/3/21 11:06:24
 */
public class MigratoryBirdsSolution {
    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
       Map<Integer,Integer> map = new Hashtable<>(n);
       int count=0;
        for (int element : ar) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            } else {
                map.put(element, count+1);
            }
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
            if (maxEntry.getValue().compareTo(entry.getValue()) == 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    private static String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int ar_i = 0; ar_i < n; ar_i++){
//            ar[ar_i] = in.nextInt();
//        }

        try {
            String s = readFileAsString("C:\\Users\\dixin\\Desktop\\errorlog\\migratory.txt");
            String[] list = s.split(",");
            int n=124992;
            int[] ar= new int[n];
            for (int i = 0; i < list.length; i++) {
                ar[i] = Integer.valueOf(list[i].trim());
            }

            int result = migratoryBirds(n, ar);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
