package problemsolvingpatterns.multipepointers.sumzero;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a function called sumZero which accepts a sorted array of integers.
 * The function should find the first pair where the sum is 0.
 * Return an array that includes both values that sum to zero or undefined
 * if a pair does not exist
 * 
 * Examples: 
 * 
 * sumZero([-3,-2,-1,0,1,2,3]) // [-3,3] 
 * sumZero([-2,0,1,3]) // undefined
 * sumZero([1,2,3]) // undefined
 * 
 */
public class SumZero {
  /**
   * Approach #1: O(n^2)
   * 
   * loop over the each element and compare each element with other element in the nested loop
   * 
   * @param numbers
   * @return
   */
  public static int[] sumZero1(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        int sum = numbers[i] + numbers[j];
        if (sum == 0) {
          return new int[]{numbers[i], numbers[i]};
        }
      }
    }
    return new int[]{};
  }

  /**
   * Approach #2: O(n)
   * 
   * define a two pointers left and right. Assign the first index to the left and the last to the right pointers
   * loop over the array
   *  sum the elements at left and right
   *  if the sum is zero return new array containing the element at the left and right pointers
   *  if the sum is less than zero, move the left pointer to the right by one
   *  if the sum is greater than zero, move the right pointer to the left by one
   * end the loop
   * return empty array
   * 
   * @return
   */
  public static int[] sumZero2(int[] numbers) {
    int left = 0; 
    int right = numbers.length - 1;

    while (left != right) {
      int sum = numbers[left] + numbers[right];
      if (sum == 0) {
        return new int[]{numbers[left], numbers[right]};
      } else if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    test(new int[]{-3,-2,-1,0,1,2,3}, 1);
    test(new int[]{-2,0,1,3}, 2);
    test(new int[]{1,2,3}, 3);
    test(new int[]{-4,-2,-1,0,1,2,3}, 4);
  }

  public static void test(int[] nums, int caseNumber) {
    System.out.println("Case #" + caseNumber + ": " + Arrays.stream(sumZero2(nums)).boxed().toList());
  }
}
