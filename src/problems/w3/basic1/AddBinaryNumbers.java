package problems.w3.basic1;

import java.util.Scanner;

public class AddBinaryNumbers {
    public static void main(String[] args) {
        solution2();
    }

    public static void solution1() {
        Scanner sc = new Scanner(System.in);
        int binary1, binary2;
        int i = 0, remainder = 0;
        int[] sum = new int[20];

        System.out.print("Enter the first binary number: ");
        binary1 = sc.nextInt();

        System.out.print("Enter the second binary number: ");
        binary2 = sc.nextInt();

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (int) ((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int) ((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 /= 10;
            binary2 /= 10;
        }

        if (remainder != 0) {
            sum[i] = remainder;
        }

        System.out.print("Sum of two binary numbers: ");
        while (i >= 0) {
            System.out.print(sum[i--]);
        }
    }

    public static void solution2() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Input the first binary number: ");
            long binary1 = Long.parseLong(sc.next(), 2);

            System.out.print("Input the second binary number: ");
            long binary2 = Long.parseLong(sc.next(), 2);

            System.out.format("Sum of two binary numbers: %s%n", Long.toBinaryString(binary1 + binary2));
        }
    }
}
