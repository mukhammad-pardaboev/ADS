package problemsolvingpatterns.slidingwindow.maxsubarraysum;

/**
 * max
 * num = 2
 * i = 0
 * { 1, 2, 5, 2, 8, 1, 5 }
 *   0  1  2  3  4  5  6
 */

public class Solution2 {
  public static Integer maxSubArraySum(int[] numbers, int num) {
    if (numbers.length == 0 || numbers.length < num) {
      return null;
    }
    int maxSum = 0;

    for (int i = 0; i < num; i++) {
      maxSum += numbers[i];
    }

    int temp = maxSum;

    for (int i = 0; i < numbers.length - num; i++) {
      temp = temp - numbers[i] + numbers[i + num];
      maxSum = Math.max(maxSum, temp);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] numbers = new int[] {};
    Integer result = maxSubArraySum(numbers, 4);
    System.out.println(result);
  }
}
