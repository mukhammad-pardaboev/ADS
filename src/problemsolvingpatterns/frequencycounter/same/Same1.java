package problemsolvingpatterns.frequencycounter.same;

public class Same1 {
  public static void main(String[] args) {
    int[] arr1 = new int[] { 1, 2, 3 };
    int[] arr2 = new int[] { 1, 4, 9 };

    System.out.println(same(arr1, arr2));
  }

  public static boolean same(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.length; i++) {
      int squared = arr1[i] * arr1[i];
      int correctIndex = indexOf(arr2, squared);
      if (correctIndex == -1) {
        return false;
      } else {
        arr2 = remove(arr2, correctIndex);
      }
    }
    return true;
  }

  private static int indexOf(int[] arr, int value) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        return i;
      }
    }
    return -1;
  }

  private static int[] remove(int[] arr, int index) {
    if (arr.length <= index) {
      return arr;
    }
    int[] newArr = new int[arr.length - 1];
    for (int i = 0, j = 0; i < arr.length; i++) {
      if (i == index) {
        continue;
      }
      newArr[j++] = arr[i];
    }
    return newArr;
  }
}
