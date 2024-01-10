package problems.w3.array;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3, 1};
        System.out.println("Case 1: " + Arrays.toString(sort2(arr1)));
        System.out.println("Remove element: " + Arrays.toString(removeElement(arr1, 5)));
    }
    public static int[] sort1(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] sort2(int[] arr) {
        int len = arr.length;
        int[] newArr = new int[len];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (min > arr[j]) min = arr[j];
            }
            newArr[k++] = min;
            arr = removeElement(arr, min);
            System.out.println(Arrays.toString(arr));
           i = -1;
        }
        return newArr;
    }
    private static int[] removeElement(int[] arr, int el) {
        int[] newArr = new int[arr.length - 1];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != el) {
                if (k == arr.length - 1) return arr;
                newArr[k++] = arr[i];
            }
        }
        return newArr;
    }
}
