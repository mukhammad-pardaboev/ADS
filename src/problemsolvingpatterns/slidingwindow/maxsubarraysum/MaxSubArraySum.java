package problemsolvingpatterns.slidingwindow.maxsubarraysum;

import java.util.Arrays;

/**
 * Write a function called maxSubArraySum which accepts an array of integers and
 * a number called n.
 * The function should calculate the maximum sum of n consecutive elements in
 * the array.
 * 
 * Examples:
 * 
 * maxSubArraySum([1,2,5,2,8,1,5],2) // 10
 * maxSubArraySum([1,2,5,2,8,1,5],4) // 17
 * maxSubArraySum([4,2,1,6],1) // 6
 * maxSubArraySum([4,2,1,6,2],4) // 13
 * maxSubArraySum([],4) // null
 */
public class MaxSubArraySum {
  /**
   * Approach #1 (Naive): O(n^2)
   * 
   * define a variable to hold the maxsum
   * iterate over the array and sum the first n consecutive numbers in the array
   * and assign it to maxsum
   * iterate over the array
   * create nested loop which starts at second index
   * sum n consecutive numbers and sum them
   * compare the sum with maxsum
   * if sum greater than maxsum, then assign maxsum variable sum
   * 
   * return maxsum
   */
  public static int maxSubArraySum1(int[] arr, int n) {
    if (arr.length < n)
      return 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length - n + 1; i++) {
      int sum = 0;
      for (int j = 0; j < n; j++) {
        sum += arr[i + j];
      }
      maxSum = sum > maxSum ? sum : maxSum;
    }
    return maxSum;
  }

  /**
   * Approach #2: O(n)
   * 
   * sum first n consecutive number of the array and assign the sum to maxSum variable
   * iterate over the loop starting from the (n + 1) the element and till the end of the array
   *  calculate the sum by subtracting the first element and adding the (n + 1) the element
   *  if sum is greater than maxSum, assign sum to maxSum var
   * return maxSum;
   */
  public static int maxSubArraySum2(int[] arr, int n) {
    if (arr.length < n) return 0;
    int maxSum = 0;
    int tempSum = 0;
    for (int i = 0; i < n; i++) {
      maxSum += arr[i];
    }
    tempSum = maxSum;
    for (int i = n; i < arr.length; i++) {
      tempSum = tempSum - arr[i - n] + arr[i];
      maxSum = Math.max(maxSum, tempSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    test(new int[] { 1, 2, 5, 2, 8, 1, 5 }, 2, 1);
    test(new int[] { 1, 2, 5, 2, 8, 1, 5 }, 4, 2);
    test(new int[] { 4, 2, 1, 6 }, 1, 3);
    test(new int[] { 4, 2, 1, 6 }, 4, 4);
    test(new int[] { 4, 2, 1, 6, 2 }, 4, 5);
    test(new int[] {}, 4, 6);
  }

  public static void test(int[] arr, int n, int caseNum) {
    System.out.println("Case #" + caseNum + ":");
    System.out.println("Input: " + "arr = " + Arrays.toString(arr) + ", n = " + n);
    System.out.println("Result: " + maxSubArraySum2(arr, n));
  }
}
