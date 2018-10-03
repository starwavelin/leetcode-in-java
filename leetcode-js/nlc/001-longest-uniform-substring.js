/**************
* Problem No. : NLC 1
* Problem Name: Longest Uniform Substring
* Problem URL :
* Date        : Oct 2 2018
* Author      : Xian Lin
***************/

function lus(arr) {
  let len = 0, index = -1;
  if (!Array.isArray(arr) || arr.length == 0) {
    return [-1, 0];
  }
  if (arr.length == 1) {
    return [0, 1];
  }
  let i = 1, curLen = 1, curIndex = 0;
  while (i < arr.length) {
    if (arr[i] !== arr[i - 1]) {
      curLen = 1;
      curIndex = i;
    } else {
      curLen++;
    }
    if (curLen > len) {
      len = curLen;
      index = curIndex;
    }
    i++;
  }
  return [index, len];
}

/** Test Cases **/
console.log(lus(undefined));

console.log(lus([]));

console.log(lus(['a', 'a', 'b', 'c', 'c', 'c', 'a']));

console.log(lus(['a', 'a', 'a', 'a']));

console.log(lus(['a', 'b', 'd', 'd', 'f']));
