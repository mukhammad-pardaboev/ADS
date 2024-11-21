package bigo;

public class Double {
  public static int[] doubleElements(int[] arr) {
    int[] newArr = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      newArr[i] = arr[i] * 2;
    }
    return newArr;
  }
}
