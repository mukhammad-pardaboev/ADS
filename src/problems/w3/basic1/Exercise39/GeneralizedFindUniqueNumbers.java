package problems.w3.basic1.Exercise39;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedFindUniqueNumbers {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4}; // n number of digits
        int k = 3; // k-digit unique numbers
        List<Integer> uniqueNumbers = new ArrayList<>();
        generateNumbers(digits, new boolean[digits.length], 0, k, 0, uniqueNumbers);

        // Print unique numbers and count
        for (int number : uniqueNumbers) {
            System.out.println(number);
        }
        System.out.println("Number of unique " + k + "-digit numbers: " + uniqueNumbers.size());
    }

    public static void generateNumbers(int[] digits, boolean[] used, int position, int k, int currentNumber, List<Integer> uniqueNumbers) {
        if (position == k) {
            // Base case: k digits are selected, so print the number
            uniqueNumbers.add(currentNumber);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                // Mark the digit as used
                used[i] = true;

                // Choose the next digit and increase the position
                generateNumbers(digits, used, position + 1, k, currentNumber * 10 + digits[i], uniqueNumbers);

                // Reset the digit as unused for the next iterations
                used[i] = false;
            }
        }
    }
}
