# Multiple pointers pattern

Creating pointers or values that correspond to an index or position and move towards the beginning, end, or middle based on a certain condition.
This pattern is often used to solve problems involving sorted arrays or linked lists, where you need to find pairs or triplets that meet certain criteria. 

## Example Problems
- **Two Sum**: Find two numbers in a sorted array that add up to a specific target.

### Two Sum example 

Write a function called sumZero which accepts a sorted array of integers.
The function should find the first pair where the sum is 0.
Return an array that includes both values that sum to zero or undefined
if a pair does not exist

e.g:
sumZero([-3,-2,-1,0,1,2,3]) // [-3,3] 
sumZero([-2,0,1,3]) // undefined
sumZero([1,2,3]) // undefined

```java
public class SumZero {
  public static int[] sumZero(int[] numbers) {
    int left = 0; 
    int right = numbers.length - 1;

    while (left != right) {
      int sum = numbers[left] + numbers[right];
      if (sum == 0) {
        return new int[]{numbers[left], numbers[right]};
      } else if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }
    return new int[]{};
  }
}
```
