package com.alexstudy.hackrank.Algorithms.Implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author AlexTong
 * @ClassName ClimbingLeaderboardSolution
 * @Description TODO()
 * @date 2018/3/28 15:33:54
 */
public class ClimbingLeaderboardSolution {
    /*
   * Complete the climbingLeaderboard function below.
   */
    static Integer[] climbingLeaderboard(int[] scores, int[] alice) {
        /*
         * Write your code here.
         */
        int result = 1;
        boolean b[] = new boolean[alice.length];
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        TreeMap<Integer,Integer> aliceMap = new TreeMap<Integer,Integer>();
        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        for(int score: scores){
            if (!treeMap.containsKey(score)) {
                treeMap.put(score,result);
                result++;
            }
        }

        for(int i = 0; i < alice.length; i++){
            if (aliceMap.containsKey(alice[i])) {
                b[i] = true;
            }
            if(treeMap.ceilingEntry(alice[i]) == null){
                aliceMap.put(alice[i],1);
            } else {
                Map.Entry<Integer,Integer> entry = treeMap.ceilingEntry(alice[i]);
                if (entry.getKey() == alice[i]) {
                    aliceMap.put(alice[i], entry.getValue());
                } else {
                    aliceMap.put(alice[i], entry.getValue()+1);
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry: aliceMap.entrySet()){
            tempArray.add(entry.getValue());
        }
        int size = tempArray.size();
        if (tempArray.size() != alice.length) {
            for(int j = 0; j < b.length; j++){
                if(b[j] == true){
                    tempArray.add(j,tempArray.get(j-1));
                }
            }
        }
        Integer[] resultArray = new Integer[size];
        resultArray =  (Integer[]) tempArray.toArray(resultArray);
        return resultArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int scoresCount = Integer.parseInt(scanner.nextLine().trim());
//
//        int[] scores = new int[scoresCount];
//
//        String[] scoresItems = scanner.nextLine().split(" ");
//
//        for (int scoresItr = 0; scoresItr < scoresCount; scoresItr++) {
//            int scoresItem = Integer.parseInt(scoresItems[scoresItr].trim());
//            scores[scoresItr] = scoresItem;
//        }
//
//        int aliceCount = Integer.parseInt(scanner.nextLine().trim());
//
//        int[] alice = new int[aliceCount];
//
//        String[] aliceItems = scanner.nextLine().split(" ");
//
//        for (int aliceItr = 0; aliceItr < aliceCount; aliceItr++) {
//            int aliceItem = Integer.parseInt(aliceItems[aliceItr].trim());
//            alice[aliceItr] = aliceItem;
//        }
        int[] scores = {100,100,50,40,40,20,10};
        int[] alice = {5,25,50,120};
        Integer[] result = climbingLeaderboard(scores, alice);

        System.out.print(result.length);

//        for (int resultItr = 0; resultItr < result.length; resultItr++) {
//            bufferedWriter.write(String.valueOf(result[resultItr]));
//
//            if (resultItr != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }

}
