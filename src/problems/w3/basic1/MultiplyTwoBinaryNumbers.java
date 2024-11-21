package problems.w3.basic1;

import java.util.Scanner;

public class MultiplyTwoBinaryNumbers {
    public static void main(String[] args) {
        solution3();
    }

    public static void solution1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the first binary number: ");
        int binary1 = Integer.parseInt(sc.next(), 2);

        System.out.print("Input the second binary number: ");
        int binary2 = Integer.parseInt(sc.next(), 2);

        System.out.format("Product of two binary numbers: %s%n", Integer.toBinaryString(binary1 * binary2));
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int i = 0, marker = 0, remainder = 0;
        int[] product = new int[20];

        System.out.print("Input the first binary number: ");
        int binary1 = sc.nextInt();

        System.out.print("Input the second binary number: ");
        int binary2 = sc.nextInt();

        while (binary2 != 0) {
            int multiplier = binary2 % 10;
            binary2 /= 10;
            int temp = binary1;

            i = marker;
            while (temp != 0) {
                int tempProduct = (product[i] + (temp % 10 * multiplier) + remainder);
                product[i] = tempProduct % 2;
                remainder = tempProduct / 2;
                temp /= 10;
                i++;
            }
            if (remainder != 0) {
                product[i] = remainder;
                remainder = 0;
            } else {
                i--;
            }
            marker++;
        }

        System.out.print("Product of two binary numbers: ");
        while (i >= 0) {
            System.out.print(product[i--]);
        }
        System.out.println();
    }

    public static void solution3() {
        // Declare variables to store two binary numbers and the product
        long binary1, binary2, multiply = 0;

        // Initialize digit and factor variables for processing binary2
        int digit, factor = 1;

        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Prompt the user to input the first binary number
        System.out.print("Input the first binary number: ");
        binary1 = in.nextLong();

        // Prompt the user to input the second binary number
        System.out.print("Input the second binary number: ");
        binary2 = in.nextLong();

        // Process binary2 to calculate the product
        while (binary2 != 0) {
            digit = (int)(binary2 % 10);
            if (digit == 1) {
                binary1 = binary1 * factor;
                multiply = binaryproduct((int) binary1, (int) multiply);
            } else {
                binary1 = binary1 * factor;
            }
            binary2 = binary2 / 10;
            factor = 10;
        }

        // Display the product of the two binary numbers
        System.out.print("Product of two binary numbers: " + multiply + "\n");
    }

    // Method to calculate the product of two binary numbers
    static int binaryproduct(int binary1, int binary2) {
        int i = 0, remainder = 0;
        int[] sum = new int[20];
        int binary_prod_result = 0;

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
            remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }

        if (remainder != 0) {
            sum[i++] = remainder;
        }

        --i;

        while (i >= 0) {
            binary_prod_result = binary_prod_result * 10 + sum[i--];
        }

        return binary_prod_result;
    }
}
