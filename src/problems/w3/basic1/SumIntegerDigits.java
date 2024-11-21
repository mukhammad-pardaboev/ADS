package problems.w3.basic1;

public class SumIntegerDigits {
    public static void main(String[] args) {
        int num = 255;
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            sum += digit;
        }
        System.out.println("The sum of digits: " + sum);
    }
}
