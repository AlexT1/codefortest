package com.alexstudy.base;

import java.text.DecimalFormat;

/**
 * @ClassName ValueOfDemo
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/1/17
 */
public class IntValueOfDemo {
//    int value
//    public static void main(String[] args) {
//        int numArgs = args.length;
//
//        //this program requires at least two arguments on the command line
//        if (numArgs < 2) {
//            System.out.println("This program requires two command-line arguments.");
//        } else {
//            int sum = 0;
//
//            for (int i = 0; i < numArgs; i++) {
//                sum += Integer.valueOf(args[i]).intValue();
//            }
//
//            //print the sum
//            System.out.println(sum);
//        }
//    }
    public static void main(String[] args) {

        int numArgs = args.length;

        //this program requires at least two arguments on the command line
        if (numArgs < 2) {
            System.out.println("This program requires two command-line arguments.");
        } else {
            double sum = 0.0;

            for (int i = 0; i < numArgs; i++) {
                sum += Double.valueOf(args[i]).doubleValue();
            }

            //format the sum
            DecimalFormat myFormatter = new DecimalFormat("###,###.##");
            String output = myFormatter.format(sum);

            //print the sum
            System.out.println(output);
        }
    }

//    public static void main(String[] args) {
//        String base5String = "230";
//        int result = Integer.valueOf(base5String, 5);
//        System.out.println(result);
//        BigDecimal sum = new BigDecimal(0);
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("java Adder: ");
//
//        if (scanner.hasNextLine()) {
//            String[] inputArray= scanner.nextLine().split(" ");
//          for(String s:inputArray){
//             sum = sum.add(BigDecimal.valueOf(Double.valueOf(s)));
//          }
//            System.out.format(Locale.FRANCE,"%.2f",sum);
//        } else {
//            System.out.println("please input int value");
//        }
//    }
}
