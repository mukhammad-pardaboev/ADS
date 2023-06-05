package problemsolvingpatterns;

import java.util.ArrayList;

/*
 * Write a function called same, which accepts two arrays. 
 * The function should return true if every value in the array has its corresponding value
 * squared in the second array. The frequency of values must be the same.
 */

 /*
  * sam([1, 2, 3], [1, 4, 9]) => true
    sam([1, 2, 5, 2], [1, 4, 4, 20]) => false
    sam([1, 2, 3, 4], [1, 1, 9, 16]) => false
    sam([1], [1, 9]) => false
  */

public class FrequencyCounterPattern {
  public static void main(String[] args) {
  }

  public static boolean same1(int[] arr1, int[] arr2) {
    // check if length of arrays are equal, if not
    if (arr1.length != arr2.length)
      // return false
        return false;
    // loop through the first array
//    arr1
      // loop though the second array
      // check if the element in the first array has its value squared in the second array
        // if not return false
      // if exists remove the that element from the second array and continue looping
     return true;
  }
}
