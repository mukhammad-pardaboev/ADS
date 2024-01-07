package problemsolvingpatterns.multipepointers.countuniquevalues;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
  public static int countUniqueValues(int[] arr) {
    Set<Integer> uniqueIntegers = new HashSet<>();

    for (Integer i : arr) {
      uniqueIntegers.add(i);
    }
    return uniqueIntegers.size();
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,4,4,7,7,12,12,13};
    System.out.println(countUniqueValues(arr));
  }
}
