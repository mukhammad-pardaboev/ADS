package problemsolvingpatterns.multipepointers.sumzero;

import java.util.ArrayList;
import java.util.Arrays;

public class SumZero2 {
  public static void main(String[] args) {
    int[] arr = new int[] { -3, -2, -1, 0, 1, 2, 3 };
    System.out.println(new ArrayList<>().toArray());
    System.out.println(Arrays.toString(sumZero(arr)));
  }

  public static int[] sumZero(int[] arr) {
    if (arr.length <= 1) {
      return null;
    }
    
    int left = 0;
    int right = arr.length - 1;
    while ((right - left) != 0) {
      int sum = arr[left] + arr[right];
      if (sum > 0) {
        right--;
      } else if (sum < 0) {
        left++;
      } else {
        return new int[] { arr[left], arr[right] };
      }
    }
    return null;
  }
}
