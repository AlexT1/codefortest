package com.alexstudy.base;

/**
 * @ClassName ComputePayment
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/3 16:40:11
 */
public class ComputePayment {
    public double computePayment(double loanAmt, double rate, double futureValue, int numPeriods) {
        double interest = rate / 100.0;
        double partial1 = Math.pow((1 + interest),
                - numPeriods);
        double denominator = (1 - partial1) / interest;
        double answer = (-loanAmt / denominator)
                - ((futureValue * partial1) / denominator);
        return answer;
    }

    public static void main(String[] args){
        ComputePayment computePayment = new ComputePayment();
        System.out.printf("%s: %d, %s%n", "alex", 12346, "district205");
        System.out.printf("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
        computePayment.computePayment(23000.00, 7.0, 25000.00, 12);
    }
}
