package problems.leetcode.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Task: 442. Find All Duplicates in an Array
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: []
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 */
public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println("Case 1: " + findDuplicates5(new int[]{4,3,2,7,8,2,3,1})); // output: [2, 3]
        System.out.println("Case 1: " + findDuplicates4(new int[]{1, 1, 2})); // output: [1]
        System.out.println("Case 1: " + findDuplicates4(new int[]{1})); // output: []
    }
    public static List<Integer> findDuplicates1(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry:counter.entrySet()) {
            if (entry.getValue() > 1)
                duplicates.add(entry.getKey());
        }
        return duplicates;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num)) {
                duplicates.add(num);
            } else {
                set.add(num);
            }
        }

        return duplicates;
    }

    public static List<Integer> findDuplicates3(int[] nums) {
        int[] arr = new int[nums.length + 1];
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            arr[num]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) duplicates.add(i);
        }

        return duplicates;
    }

    public static List<Integer> findDuplicates4(int[] nums) {
        List<Integer> duplicates = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int t = Math.abs(nums[i]);
            if (nums[t - 1] < 0) {
                duplicates.add(t);
            } else {
                nums[t - 1] *= -1;
            }
        }

        return duplicates;
    }

    // Using Java 8 streams API
    public static List<Integer> findDuplicates5(int[] nums) {
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}
