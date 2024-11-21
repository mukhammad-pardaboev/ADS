package problemsolvingpatterns.slidingwindow.maxsubarraysum;

/**
 * max
 * num = 2
 * i = 0
 * { 1, 2, 5, 2, 8, 1, 5 }
 *   0  1  2  3  4  5  6
 */

public class Solution3 {
  public static void main(String[] args) {
    int result = maxSubArraySum(new int[]{1, 2, 5, 2, 8, 1, 5}, 2);
    System.out.println(result);
  }

  public static int maxSubArraySum(int[] array, int window) {
    int sum = 0, maxSum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
      if (i >= window) sum -= array[i - window];
      if (sum > maxSum) maxSum = sum;
    }

    return maxSum;
  }
}
