/*
    Write a function called sumZero which accepts a sorted array of integers.
    The function should find the first pair where the sum is 0.
    Return an array that includes both values that sum to zero or undefined
    if a pair does not exist

sumZero([-3,-2,-1,0,1,2,3]) // [-3,3] 
sumZero([-2,0,1,3]) // undefined
sumZero([1,2,3]) // undefined

1-Solution O(n**2)

// loop over the array
    // define placeholdr variable to hold the value of the current index
    // loop over the array from the current index
    // sum the each value from the inner loop
    // is the sum is zero, return the pair as an array
// return undefined

2-Solution O(n)

// define the two pointer
// while substruction of two pointers are greater than zero
    // sum the value of the pointers
    // if the sum is less than zero, move the left pointer to left
    // if the sum is greater than zero, move the right pointer to the right
    else return the pair as an array
// return undefined
*/

// 1-Solution O(n**2)
function sumZero(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      let sum = arr[i] + arr[j];
      if (sum === 0) {
        return [arr[i], arr[j]]
      }
    }
  }
  return undefined;
}

// 2-Solution O(n)
function sumZero(arr) {
  if (arr.length <= 1) {
    return undefined;
  }
  let left = 0;
  let right = arr.length - 1;
  while ((left - right) !== 0) {
    let sum = arr[left] + arr[right];
    if (sum > 0) {
      right--;
    } else if (sum < 0) {
      left++;
    } else {
      return [arr[left], arr[right]];
    }
  }
  return undefined;
}

sumZero([-3, -2, -1, 0, 1, 2, 3])
