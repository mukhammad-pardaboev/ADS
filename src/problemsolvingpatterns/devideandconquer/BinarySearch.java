package problemsolvingpatterns.devideandconquer;

import java.util.Arrays;

/**
 * Given a sorted array of integers, write a function called `binarySearch` that
 * accepts a value
 * and returns the index where the value passed to the function is located.
 * If the value is not found, return -1.
 * 
 * Examples:
 * 
 * binarySearch([1,2,3,4,5,6], 4) // 3
 * binarySearch([1,2,3,4,5,6], 6) // 5
 * binarySearch([1,2,3,4,5,6], 11) // -1
 */
public class BinarySearch {
  /**
   * Approach #1: O(n)
   * 
   * loop through the array and compare the each element with the given value
   * if the value is equal to the first element occurred, then return the index
   */
  public static int binarySearch1(int[] arr, int n) {
    for (int i = 0; i < arr.length; i++) {
      if (n == arr[i]) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Approach #2: log(n)
   * 
   * define two variable called left and right and
   * assign 0 to the left and assign the last index to the right
   * loop the array till the left less than right
   * find the middle element
   * if the middle equals to the given value, return the middle index
   * if the middle greater than the value, move the right to the position of the
   * middle
   * else move the left to the position of the middle
   * return -1
   * 
   * left, right, mid
   * 0     5      2
   * 3     5      4
   * 3.    3.     3
   */
  public static int binarySearch2(int[] arr, int n) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int midIndex = left + (right - left) / 2;
      if (arr[midIndex] == n) {
        return midIndex;
      } else if (arr[midIndex] > n) {
        right = midIndex - 1;
      } else {
        left = midIndex + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    test(new int[] { 1, 2, 3, 4, 5, 6 }, 4, 1); // 3
    test(new int[] { 1, 2, 3, 4, 5, 6 }, 6, 2); // 5
    test(new int[] { 1, 2, 3, 4, 5, 6 }, 11, 3); // -1
    test(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, 11, 4); // -1
  }

  public static void test(int[] arr, int n, int caseNum) {
    System.out.println("Case #" + caseNum + ":");
    System.out.println("Input: " + "arr = " + Arrays.toString(arr) + ", n = " + n);
    System.out.println("Result: " + binarySearch2(arr, n));
    System.out.println();
  }
}
