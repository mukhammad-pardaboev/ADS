package problems.w3.basic1;

import java.util.Scanner;

public class CalculateAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = new int[3];

        System.out.println("Please enter the three number: ");
        for (int i = 0; i < 3; i++) {
            inputs[i] = scanner.nextInt();
        }
        System.out.println("The Average: " + calculateAverage(inputs));
    }

    public static double calculateAverage(int[] nums) {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum/nums.length;
    }
}
