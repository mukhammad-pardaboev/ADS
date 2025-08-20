package problemsolvingpatterns.frequencycounter.same;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Write a function called same, which accepts two arrays of integers.
 * The function should return true if every value in the array has its
 * corresponding value
 * squared in the second array. The frequency of values must be the same.
 * 
 * Examples:
 * same([1, 2, 3], [1, 4, 9]) => true
 * same([1, 2, 5, 2], [1, 4, 4, 20]) => false
 * same([1, 2, 3, 4], [1, 1, 9, 16]) => false
 * same([1], [1, 9]) => false
 * same([], [1]) => ?
 * same(['1', '2'], ['1', '4']) => ?
 */
public class Same {
  /**
   * Approach #1: O(n^2)
   * convert arrays into ArrayList
   * loop through the first array
   * and find the index of the current element in the second arraylist
   * if index not found return false
   * else remove the element at this index
   * return true
   * 
   * @param nums1
   * @param nums2
   * @return Boolean
   */
  public static boolean isSame1(int[] nums1, int[] nums2) {

    if (nums1.length != nums2.length) {
      return false;
    }

    List<Integer> numList = new ArrayList<>();
    for (int item : nums2) {
      numList.add(item);
    }

    for (int item : nums1) {
      Integer index = numList.indexOf(item * item);
      if (index == -1) {
        return false;
      } else {
        numList.remove(index);
      }
    }
    return true;
  }

  /**
   * Approach #2: O(n)
   * 
   * create a map for storing the frequency of ech unique element in the array
   * loop each element in second array
   * if element is not in the map, put it as a key and 1 as a value
   * if element is in the map, then increase its value by one
   * loop over each element of the first array
   * if the squared current element doesn't exist in the map or equals zero,
   * return false
   * if the squared current element exists in the map, then decrease the value of
   * that element in the map by one
   * return true
   * 
   * @param nums1
   * @param nums2
   * @return
   */
  public static boolean isSame2(int[] nums1, int[] nums2) {
    if (nums1.length != nums2.length) {
      return false;
    }
    Map<Integer, Integer> lookup = new HashMap<>();

    for (int i : nums2) {
      lookup.put(i, lookup.getOrDefault(i, 0) + 1);
    }

    for (int i : nums1) {
      int squared = i * i;
      int count = lookup.getOrDefault(squared, 0);
      if (count <= 0) {
        return false;
      } else {
        lookup.put(squared, count - 1);
      }
    }
    return true;
  }

  public static boolean isSameFunctional1(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      return false;
    }

    Map<Integer, Long> lookup = Arrays.stream(arr2)
        .boxed()
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()));

    return Arrays.stream(arr1)
        .allMatch(num -> {
          int square = num * num;
          Long count = lookup.getOrDefault(square, 0L);
          if (count <= 0) {
            return false;
          }
          lookup.put(square, count - 1);
          return true;
        });
  }

  public static boolean isSameFunctional2(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      return false;
    }

    Map<Integer, Long> loopkup1 = Arrays.stream(arr1)
        .map(i -> i * i)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    
    Map<Integer, Long> loopkup2 = Arrays.stream(arr2)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return loopkup1.equals(loopkup2);
  }

  public static void main(String[] args) {
    test(new int[] { 1, 2, 3 }, new int[] { 1, 4, 9 }, 1);
    test(new int[] { 1, 2, 5, 2 }, new int[] { 1, 4, 4, 20 }, 2);
    test(new int[] { 1, 2, 3, 4 }, new int[] { 1, 1, 9, 16 }, 3);
    test(new int[] { 1 }, new int[] { 9 }, 4);
    test(new int[] {}, new int[] { 1 }, 5);
  }

  public static void test(int[] arr1, int[] arr2, int caseNumber) {
    System.out.println("Test case #" + caseNumber + " " + isSameFunctional2(arr1, arr2));
  }
}
