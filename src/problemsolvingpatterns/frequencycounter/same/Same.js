/*
 * Write a function called same, which accepts two arrays. 
 * The function should return true if every value in the array has its corresponding value
 * squared in the second array. The frequency of values must be the same.
 */

/*
    same([1, 2, 3], [1, 4, 9]) => true
    same([1, 2, 5, 2], [1, 4, 4, 20]) => false
    same([1, 2, 3, 4], [1, 1, 9, 16]) => false
    same([1], [1, 9]) => false
    same([], [1]) => ?
    same(['1', '2'], ['1', '4']) => ?
*/

// 1-Solution O(n**2)

// if the length of arrays are not equal, then return false.
// loop over the first array
// if the element is not in the second array, then return false.
// remove that element from the second array
// return true.

function same(arr1, arr2) {
  if (arr1.length !== arr2.length) return false;

  for (let i = 0; i < arr1.length; i++) {
    let correctIndex = arr2.indexOf(arr1[i] ** 2);
    if (correctIndex === -1) return false;
    arr2.splice(correctIndex, 1);
  }
  return true;
}

// // 2-Solution O(n)
// function same(arr1, arr2) {
//     // if the length of arrays are not equal, then return false.
//     // make an object/map to store the frequency of unique elements
//     // loop over the second array
//         // if element is the key in the object, add one to it
//         // else add it to object as a propery/key and asign one as a value
//     // loop over the first array
//         // square the current element
//         // if the current element is in the object/map and the value is not zero, reduce one from the value
//         // else return false
//     // return true.
// }

function same(arr1, arr2) {
  if (arr1.length !== arr2.length) {
    return false;
  }
  const counter = {};

  for (let item of arr2) {
    counter[item] = ++counter[item] || 1;
  }

  for (let item of arr1) {
    item **= 2;
    if (!counter[item]) {
      return false
    } else {
      counter[item]--;
    }
  }

  return true;
}

// 2-Solution (refactored)
function same(arr1, arr2) {
  if (arr1.length !== arr2.length) {
    return false;
  }
  const counter = {};

  for (let item of arr2) {
    counter[item] = ++counter[item] || 1;
  }

  for (let item of arr1) {
    item **= 2;
    if (!counter[item]) {
      return false
    } else {
      counter[item]--;
    }
  }

  return true;
}

same([1, 2, 3, 1], [1, 4, 9, 1])