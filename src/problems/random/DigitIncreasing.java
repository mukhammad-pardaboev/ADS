package problems.random;

/**
 * A number is called digit-increasing if it is equal to n + nn + nnn ... for some digit n between 1 and 9.
 * For example 24 is digit-increasing because it equals 2 +22 (here n=2).
 * Write a function called isDigitIncreasing that returns 1 if its argument is digit-increasing otherwise., it returns 0.
 * The signature of the method is `int isDigitIncreasing(int n)
 */

/*
    36 -> 3 + 33
    984-> 8 + 88 + 888
    37 -> ?
 */
public class DigitIncreasing {
    public static void main(String[] args) {
        System.out.println("Case 1: " + isDigitIncreasing(36));
        System.out.println("Case 2: " + isDigitIncreasing(984));
        System.out.println("Case 3: " + isDigitIncreasing(7404));
        System.out.println("Case 4: " + isDigitIncreasing(37));
    }

    public static int isDigitIncreasing(int n) {
        for (int digit = 1; digit <= 9; digit++) {
            int sum = 0;
            int currentUnit = 0;
            while (sum < n) {
                currentUnit = currentUnit * 10 + digit;
                sum += currentUnit;
            }
            if (sum == n) {
                return 1;
            }
        }
        return 0;
    }
}
