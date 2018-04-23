package com.alexstudy.hackrank.Algorithms.Implementation;

import java.io.IOException;
import java.util.*;

/**
 * @author AlexTong
 * @ClassName NonDivisibleSubsetSolution
 * @Description TODO()
 * @date 2018/4/19 16:38:37
 */
public class NonDivisibleSubsetSolution2 {
    /*
    * Complete the nonDivisibleSubset function below.
    */
//    The first line contains 2 space-separated integers, n and k, the number of values in S and the non factor.
//    The second line contains n space-separated integers describing S[i], the unique values of the set.
    static int nonDivisibleSubset(int k, int[] S) {
        /*
         * Write your code here.
         */
        int nonDivisibleSubsetCardinality = 0;

        int[] modulusBuckets = new int[k];

        //Place the values in buckets based on mod K
        for(int i = 0; i < S.length; i++)
        {
            int bucket = S[i] % k;
            modulusBuckets[bucket] += 1;
        }

        //Adds 1 if there is only 1 element in the 0 bucket or the k/2 bucket because these are edge cases
        nonDivisibleSubsetCardinality += (modulusBuckets[0] >= 1) ? 1 : 0;
        nonDivisibleSubsetCardinality += (k%2 == 0 && modulusBuckets[k/2] >= 1) ? 1 : 0;

        //Determine the max buckets we can use
        int maxBuckets = 0;
        if(k%2 == 0)
        {
            maxBuckets = (k/2)-1;
        }
        else
        {
            maxBuckets = k/2;
        }

        //Picks the biggest bucket of each pair for each even sum group
        for(int i = 1; i <= maxBuckets; i++)
        {
            nonDivisibleSubsetCardinality += Math.max(modulusBuckets[i], modulusBuckets[k-i]);
        }
        return nonDivisibleSubsetCardinality;
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