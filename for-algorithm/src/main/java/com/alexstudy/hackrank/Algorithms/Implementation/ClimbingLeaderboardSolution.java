package com.alexstudy.hackrank.Algorithms.Implementation;

import java.io.IOException;
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
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        /*
         * Write your code here.
         */
        int result = 1,index=0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        int[] resultArray = new int[alice.length];
        for(int score: scores){
            if (!treeMap.containsKey(score)) {
                treeMap.put(score,result);
                result++;
            }
            if (alice[index] >= score && index < alice.length) {
                resultArray[index] = treeMap.get(score)+1;
                index++;
            } else {
                resultArray[index] = (alice.length+1);
                index++;
                continue;
            }
        }

//        for(int i = 0; i < alice.length; i++) {
//
//            for (Map.Entry<Integer,Integer> score: treeMap.entrySet()) {
//                if(score.getKey().compareTo(alice[i]) <= 0) {
//                    resultArray[i] = score.getValue();
//                    continue;
//                } else {
//                    resultArray[i] = score.getValue()+1;
//                    break;
//                }
//            }
//        }
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
        int[] result = climbingLeaderboard(scores, alice);

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
