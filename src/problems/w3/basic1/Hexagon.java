package problems.w3.basic1;

import java.util.Scanner;

public class Hexagon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the length of the hexagon side: ");
        double s = sc.nextDouble();

        double area = (6 * s*s) / (4 * Math.tan(Math.PI/6));
        System.out.println("The area of hexagon: " + area);
    }
}
