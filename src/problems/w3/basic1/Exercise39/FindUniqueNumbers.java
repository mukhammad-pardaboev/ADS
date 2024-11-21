package problems.w3.basic1.Exercise39;

public class FindUniqueNumbers {
    public static void main(String[] args) {
        solution1();
    }

    public static void solution1() {
        int uniqueNumberCount = 0;
        int[] digits = {1, 2, 3, 4};

        for (int i = 0; i < digits.length; i++) {
            int first = digits[i];
            for (int j = 0; j < digits.length; j++) {
                int second = digits[j];
                if (second != first) {
                    for (int k = 0; k < digits.length; k++) {
                        int third = digits[k];
                        if (third != first && third != second) {
                            int number = first * 100 + second * 10 + third;
                            System.out.println(number);
                            uniqueNumberCount++;
                        }
                    }
                }
            }
        }
        System.out.println("Number of unique numbers: " + uniqueNumberCount);
    }

    public static void solution2() {
        int uniqueNumberCount = 0;
        int[] digits = {1, 2, 3, 4};

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (j == i) continue; // Skip if the same index as i
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue; // Skip if the same index as i or j

                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    System.out.println(number);
                    uniqueNumberCount++;
                }
            }
        }
        System.out.println("Number of unique numbers: " + uniqueNumberCount);
    }
}
