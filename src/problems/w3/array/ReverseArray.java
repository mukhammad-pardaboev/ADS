package problems.w3.array;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 7, 9, 6};
        System.out.println("Reversed Array: " + Arrays.toString(reverse2(arr1)));
    }
    public static int[] reverse1(int[] arr) {
        int[] reversed = new int[arr.length];

        for (int k = 0, i = arr.length-1; i >= 0; i--) {
            reversed[k++] = arr[i];
        }
        return reversed;
    }

    public static int[] reverse2(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i- 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
