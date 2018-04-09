package com.alexstudy.hackrank.Algorithms.Implementation;

import java.util.*;

/**
 * @author AlexTong
 * @ClassName DesignerPDFViewerSolution
 * @Description TODO()
 * @date 2018/4/9 14:39:00
 */
public class DesignerPDFViewerSolution {
    static int designerPdfViewer(int[] h, String word) {
        // Complete this function
        char[] letters = {'a','b','c','d','e','f','j','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < 26; i++){
            map.put(letters[i],i);
        }
        char[] wordCarray= word.toCharArray();
        List<Integer> valueList = new ArrayList<Integer>();
        for(char letter: wordCarray){
            valueList.add(h[map.get(letter)]);
        }
        Object max = Collections.max(valueList);
        int result = wordCarray.length * 1 * Integer.valueOf(max.toString());
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}
