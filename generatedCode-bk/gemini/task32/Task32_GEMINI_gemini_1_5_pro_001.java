package gemini.task32;

import java.util.*;
import java.lang.*;

public class Task32_GEMINI_gemini_1_5_pro_001 {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int years = 0;
        while(principal < desired){
            principal += (principal * interest)*(1 - tax);
            years++;
        }
        return years;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        double principal = sc.nextDouble();
        double interest = sc.nextDouble();
        double tax = sc.nextDouble();
        double desired = sc.nextDouble();
        
        int result = calculateYears(principal, interest, tax, desired);
        System.out.println(result);
    }
}