package problemsolvingpatterns.frequencycounter.same;

import java.util.HashMap;
import java.util.Map;

public class Same2 {
  public static void main(String[] args) {
    int[] arr1 = new int[] { 1, 2, 3 };
    int[] arr2 = new int[] { 1, 4, 9 };

    System.out.println(same(arr1, arr2));
  }
  public static boolean same(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      return false;
    }
    Map<Integer, Integer> lookup = new HashMap<>();

    for (int i : arr2) {
      lookup.put(i, lookup.getOrDefault(i, 0) + 1);
    }

    for (int i : arr1) {
      int value = i * i;
      if (!lookup.containsKey(value) || lookup.get(value) <= 0) {
        return false;
      } else {
        lookup.put(value, lookup.get(value) - 1);
      }
    }
    return true;
  }
}
