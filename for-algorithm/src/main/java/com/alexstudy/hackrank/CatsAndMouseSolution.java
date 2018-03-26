package com.alexstudy.hackrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author AlexTong
 * @ClassName CatsAndMouseSolution
 * @Description TODO()
 * @date 2018/3/26 14:52:03
 */
public class CatsAndMouseSolution {

    /*
     * Complete the catAndMouse function below.
     */
    static String catAndMouse(int x, int y, int z) {
        /*
         * Write your code here.
         */
        String catA = "Cat A", catB="Cat B", mouseC = "Mouse C";
        if (Math.abs(z - x) > Math.abs(z - y)) {
            return catB;
        } else if ( Math.abs(z-x) == Math.abs(z-y)){
            return mouseC;
        } else {
            return catA;
        }
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(scan.nextLine().trim());
//
//        for (int qItr = 0; qItr < q; qItr++) {
//            String[] xyz = scan.nextLine().split(" ");
//
//            int x = Integer.parseInt(xyz[0].trim());
//
//            int y = Integer.parseInt(xyz[1].trim());
//
//            int z = Integer.parseInt(xyz[2].trim());
//
//            String result = catAndMouse(x, y, z);
//
//            bw.write(result);
//            bw.newLine();
//        }
//
//        bw.close();
        int q = 2;
        int x = 0,y = 0,z = 0;
        for (int qItr = 0; qItr < q; qItr++) {
            if (qItr == 0) {
                 x = 1;
                 y = 2;
                 z = 3;
            } else {
                x = 1;
                y = 3;
                z = 2;
            }
            String result = catAndMouse(x, y, z);
            System.out.println(result);
        }
    }

    /**
     * 舍掉小数取整:Math.floor(3.5)=3
     四舍五入取整:Math.rint(3.5)=4
     进位取整:Math.ceil(3.1)=4
     取绝对值：Math.abs(-3.5)=3.5
     取余数：A%B = 余数
     */

}
