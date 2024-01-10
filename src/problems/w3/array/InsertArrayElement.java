package problems.w3.array;

import java.util.Arrays;

public class InsertArrayElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(insert(arr, 2, 5)));
    }
    public static int[] insert(int[] arr, int index, int el) {
        int[] newArr = new int[arr.length + 1];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                newArr[k++] = el;
                newArr[k++] = arr[i];
            } else {
                newArr[k++] = arr[i];
            }
        }
        return newArr;
    }
}
