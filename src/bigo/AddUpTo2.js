/*
 Suppose we want to write a function that calculates the sum of all numbers 
 from 1 up to (and including) some number n.
*/

function addUpTo(n) {
  return n * (n + 1) / 2
}

const total = addUpTo(3);
console.log('Total: ', total)
