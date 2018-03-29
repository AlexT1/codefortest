package com.alexstudy.hackrank.Algorithms.Implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author AlexTong
 * @ClassName CountingValleysSolution
 * @Description TODO()
 * @date 2018/3/22 17:39:40
 */
public class CountingValleysSolution {
    static int countingValleys(int n, String s) {
        // Complete this function
        Map<Integer,Integer> uList = new Hashtable<>();
        Map<Integer,Integer> dList = new Hashtable<>();
        String up = "U", down = "D";
        int ucount=0,dcount=0, result=0, sealevel = 0;
        boolean specialu = false, speciald = false;
        for (int i = 0; i < s.length(); i++) {
            String as = s.substring(i, i + 1);
            if (as.equals(up)) {
                if (!uList.containsKey(i-1) && !specialu) {
                        ucount++;
                        uList.put(i, ucount);
                        specialu = true;
                        speciald = false;
                }
                sealevel++;
            }else if (as.equals(down)) {
                if (!dList.containsKey(i-1) && !speciald && sealevel==0) {
                        dcount++;
                        dList.put(i, dcount);
                        speciald = true;
                        specialu = false;

                }
                sealevel--;
            }
        }

        result = dList.size();

        return result;
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
//        String s = in.next();
//        int n = 8;
//        String s = "UDDDUDUU";
        String s;
//        int n =12;
//         s="DDUUDDUDUUUD";
        int n=12;
        s="UUDUDDDDUUDD";
//        int n =1000000;

//        try {
//            s = readFileAsString("C:\\lyj\\practicecode\\codefortest\\for-algorithm\\src\\main\\java\\com\\alexstudy\\hackrank\\valley");
            int result = countingValleys(n, s);
            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        in.close();
    }
}
