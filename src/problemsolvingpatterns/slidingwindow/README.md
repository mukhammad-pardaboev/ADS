# SLIDING WINDOW

This pattern involves creating a window which can either be an array or number from one position to another
Depending on a certain condition, the window either increases or closes (and a new window is created)
Very useful for keeping track of a subset of data in an array/string etc.

## Example Problems 

### Max Sub Array Sum

Write a function called maxSubArraySum which accepts an array of integers and a number called n.
The function should calculate the maximum sum of n consecutive elements in the array.

E.g: 

maxSubArraySum([1,2,5,2,8,1,5],2) // 10
maxSubArraySum([1,2,5,2,8,1,5],4) // 17
maxSubArraySum([4,2,1,6],1) // 6
maxSubArraySum([4,2,1,6,2],4) // 13
maxSubArraySum([],4) // null

```java
public class MaxSubArraySum {
  public static int maxSubArraySum(int[] arr, int n) {
    if (arr.length < n) return 0;
    int maxSum = 0;
    int tempSum = 0;
    for (int i = 0; i < n; i++) {
      maxSum += arr[i];
    }
    tempSum = maxSum;
    for (int i = n; i < arr.length; i++) {
      tempSum = tempSum - arr[i - n] + arr[i];
      maxSum = Math.max(maxSum, tempSum);
    }
    return maxSum;
  }
}
