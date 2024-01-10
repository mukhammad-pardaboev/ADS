package problems.w3.array;

import java.util.Arrays;

public class ArrayMaxMin {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 2, 3, 4};
        int[] arr2 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        System.out.println(Arrays.toString(maxMin2(arr2)));
    }
    public static int[] maxMin1(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];

            if (min > arr[i])
                min = arr[i];
        }
        return new int[] {max, min};
    }

    public static int[] maxMin2(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Arrays.sort(arr);
        return new int[] {arr[arr.length -1], arr[0]};
    }
}
