package gtp4o.task139;

import java.util.Scanner;

public class Task139_OPENAI_gpt_4o {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        double area = 3.14159 * radius * radius;
        System.out.println("Area of the circle is: " + area);
    }
}