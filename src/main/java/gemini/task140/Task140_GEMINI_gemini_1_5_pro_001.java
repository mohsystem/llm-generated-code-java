package gemini.task140;

import java.util.Scanner;

public class Task140_GEMINI_gemini_1_5_pro_001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter the operator (+, -, *, /): ");
        String op = scanner.next();
        
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        
        double result;
        
        switch (op) {
            case "+":
                result = num1 + num2;
                System.out.println(result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println(result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println(result);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Division by zero not allowed");
                } else {
                    result = num1 / num2;
                    System.out.println(result);
                }
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}