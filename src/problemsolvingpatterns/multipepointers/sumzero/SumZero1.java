package problemsolvingpatterns.multipepointers.sumzero;

import java.util.Arrays;

public class SumZero1 {
  public static void main(String[] args) {
    int[] arr = new int[] { -3, -2, -1, 0, 1, 2, 3 };
    System.out.println(Arrays.toString(sumZero(arr)));
  }

  public static int[] sumZero(int[] arr) {
    if (arr.length <= 1) {
      return null;
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int sum = arr[i] + arr[j];

        if (sum == 0) {
          return new int[] { arr[i], arr[j] };
        }
      }
    }
    return null;
  }
}
