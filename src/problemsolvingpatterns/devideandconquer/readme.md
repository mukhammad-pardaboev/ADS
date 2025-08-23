# Divide and Conquer pattern

This pattern involves dividing a data set into smaller chunks and then repeating a process with a subset of data. This pattern can tremendously decrease time complexity.

## Examples

- **Binary Search**: This algorithm finds the position of a target

### Binary Search example

Given a sorted array of integers, write a function called `binarySearch` that accepts a value and returns the index where the value passed to the function is located. If the value is not found, return -1.

Examples:

```
binarySearch([1,2,3,4,5,6], 4) // 3
binarySearch([1,2,3,4,5,6], 6) // 5
binarySearch([1,2,3,4,5,6], 11) // -1
```

```java
public class BinarySearch {
  public static int binarySearch(int[] arr, int n) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int midIndex = left + (right - left) / 2;
      if (arr[midIndex] == n) {
        return midIndex;
      } else if (arr[midIndex] > n) {
        right = midIndex - 1;
      } else {
        left = midIndex + 1;
      }
    }
    return -1;
  }
}
```
