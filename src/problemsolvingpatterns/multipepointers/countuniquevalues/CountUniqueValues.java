package problemsolvingpatterns.multipepointers.countuniquevalues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implement a function called countUniqueValues, which accepts a sorted array,
 * and counts the unique values in the array.
 * There can be negative numbers in the array, but it will always be sorted.
 * 
 * Examples:
 * countUniqueValues([1,1,1,1,1,2]) // 2
 * countUniqueValues([1,2,3,4,4,4,7,7,12,12,13]) // 7
 * countUniqueValues([]) // 0
 * countUniqueValues([-2,-1,-1,0,1]) // 4
 */
public class CountUniqueValues {
  /**
   * Approach #1: O(n)
   * 
   * define two pointers each pointing the first and second indexes of the array
   * iterate over the array till pointer second less than array length
   *  if the elements in first and second pointers are not equal, then move pointe up by one and assign the value at pointer second
   *  if they are equal move second pointer by one
   * return first pointer
   *  
   */
  public static int countUniqueValues1(int[] arr) {
    if (arr.length == 0) return 0;
    
    int first = 0;
    int second = 1;
    while (second < arr.length) {
      if (arr[first] != arr[second]) {
        arr[++first] = arr[second];
      }
      second++;
    }
    return first + 1;
  }

  /**
   * Approach #2: O(n)
   * 
   * Iterate ove the array and put the elements as a key to HashMap/HashSet and
   * return the size of the array
   */
  public static int countUniqueValues2(int[] arr) {
    Set<Integer> uniqueValues = new HashSet<>();
    for (int i : arr) {
      uniqueValues.add(i);
    }
    return uniqueValues.size();
  }

  /**
   * Approach #2.1: O(n)
   * 
   * Using java 8 syntax
   * 
   * Iterate ove the array and put the elements as a key to HashMap/HashSet and
   * return the size of the array
   */
  public static int countUniqueValues2Functional(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .collect(Collectors
            .toSet())
        .size();
  }

  public static void main(String[] args) {
    test(new int[] { 1, 1, 1, 1, 1, 2 }, 1);
    test(new int[] { 1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13 }, 2);
    test(new int[] {}, 3);
    test(new int[] { -2, -1, -1, 0, 1 }, 4);
  }

  public static void test(int[] arr, int caseNumber) {
    System.out.println("Case #" + caseNumber + ": " + Arrays.toString(arr));
    System.out.println(countUniqueValues1(arr));
  }
}
