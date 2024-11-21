/*
    Given two strings, write a function to determine if the second string is 
    an anagram of the first. An anagram is a word, phrase, or name formed by rearranging 
    the letters of another, such as cinema, formed from iceman.

validAnagram('', '') // true
validAnagram('aaz', 'zza') // false
validAnagram('anagram', 'nagaram') // true
validAnagram("rat","car") // false) // false
validAnagram('awesome', 'awesom') // false
validAnagram('qwerty', 'qeywrt') // true
validAnagram('texttwisttime', 'timetwisttext') // true


1 - Solution O(n**2)

// if the length of the strings are not equal, return false;
// loop over the first string
    // if current element exists in the second string, remove it from the second string
    // else return false
// return false

2 - Solution O(n)

// if the length of the string are not equal, return false;
// define lookup object
// loop over the first string
    // if the element is the key in the lookup object, increment by one
    // else add it to the object as a key and assign value one.
// loop over the second string
    // if the element is not the key in the lookup object 
    // or if exists, the value is less than or equal to zero
    // then return false
    // else decrement by one
// return true
*/

// 1 - Solution O(n**2)
function validAnagram(str1, str2) {
  if (str1.length !== str2.length) {
    return false;
  }
  for (let el of str1) {
    let correctIndex = str2.indexOf(el);

    if (correctIndex === -1) {
      return false;
    }
    str2 = str2.substring(0, correctIndex) + str2.substring(correctIndex);
  }
  return true;
}

// 2 - Solution O(n)
function validAnagram(str1, str2) {
  if (str1.length !== str2.length) {
    return false;
  }
  const lookup = {};
  for (let el of str1) {
    lookup[el] = ++lookup[el] || 1;
  }
  for (let el of str2) {
    if (!lookup[el]) {
      return false;
    } else {
      lookup[el]--;
    }
  }
  return true;
}

validAnagram('cat', 'act')
