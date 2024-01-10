package problemsolvingpatterns.multipepointers.countuniquevalues;

public class Solution2 {
  public static int countUniqueValues(int[] arr) {
    if (arr.length == 0)
      return 0;

    int first = 0;
    int second = 1;

    while (second < arr.length) {
      if (arr[first] != arr[second]) {
        first++;
        arr[first] = arr[second];
      }
      second++;
    }
    return first + 1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13 };
    System.out.println(countUniqueValues(arr));
  }
}
