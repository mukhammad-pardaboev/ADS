package pramp.findduplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time Complexity: O(n)
class Solution1 {

  static int[] findDuplicates(int[] arr1, int[] arr2) {
    // define a HashMap to store the items
    Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();
    // define a new ArrayList to store the duplicates
    List<Integer> result = new ArrayList<Integer>();
    // loop over the first array
    for (int n : arr1) {  
      // if the item is a key in the HashMap, increment it by one
      // else add it to the map with value one
      lookup.put(n, lookup.getOrDefault(n, 0) + 1);
    }
    // loop over the second array
    for (int n : arr2) {
      // if the current item is a key in the map, add it to the newArray
      if (lookup.containsKey(n)) {
        result.add(n);
      }
    }
    // return the newArray
    return result.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 5, 6, 7};
    int[] arr2 = {3, 6, 7, 8, 20};
    int[] result = findDuplicates(arr1, arr2);
    System.out.println(Arrays.toString(result));
  }
}