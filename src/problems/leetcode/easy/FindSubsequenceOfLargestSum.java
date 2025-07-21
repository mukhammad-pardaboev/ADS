package problems.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSubsequenceOfLargestSum {

  public static void main(String[] args) {
    FindSubsequenceOfLargestSum solution = new FindSubsequenceOfLargestSum();
    System.out.println(solution.findMax(new int[]{2, 3, 5, 6, 7}));
    int[] nums = {2,1,3,3};
    int k = 2;
    int[] result = solution.removeElement(nums, k);
    System.out.println(Arrays.toString(result));
  }
  public int[] maxSubsequence(int[] nums, int k) {
    /**
     map indicis by elements in arr
     sort map by value in descending order
     get the first k elememnts from the map
     sort map by index in ascending order
     map the map to arry by values
     return the array
     */

    Map<Integer, Integer> mapper = new HashMap();
    for(int i=0; i < nums.length; i++) {
      mapper.put(i, nums[i]);
    }

    int[] sortedElementIndicis = new int[nums.length];
    int maxInd = 0;
    for(int i = 0; i < nums.length; i++) {
      int element = mapper.get(i);
      for (int j = i + 1; j < nums.length; j++) {
        int current = mapper.get(j);
        if (element > current) {
          maxInd = i;
        } else {
          maxInd = j;
        }
      }
      sortedElementIndicis[i] = maxInd;
    }

    System.out.println(Arrays.toString(sortedElementIndicis));

    return sortedElementIndicis;
  }

  public int[] sort(int[] nums) {
    int[] sorted = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      sortedElementIndicis[i] = i;
    }
    int maxIndex = findMax(nums);
    return nums;
  }

  public int findMax(int[] nums) {
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  public int[] removeElement(int[] nums, int index) {
    if (index < 0 || index >= nums.length) {
      throw new IllegalArgumentException("Index out of bounds");
    }

    int[] result = new int[nums.length - 1];
    for (int i = 0; i < nums.length - 1; i++) {
      result[i] = nums[i < index ? i : i + 1];
    }
    return result;
  }
}
