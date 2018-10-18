/**************
* Problem No. : NLC 6
* Problem Name: Binary Search (Recursion)
* Problem URL :
* Date        : Oct 17 2018
* Author      : Xian Lin
***************/

function binarySearchAnyIndex(arr, target) {
  if (!arr || arr.length === 0) {
    return null;
  }
  return binarySearch(arr, 0, arr.length - 1, target);
}

function binarySearch(arr, start, end, target) {
  if (start > end) {
    return null;
  }
  let mid = start + Math.floor((end - start) / 2);
    // Kengdie's JS, it evaluates
    // mid = 3 + (4 - 3) / 2 = 3.5!!!
    // have to use Math.floor()
  if (arr[mid] == target) {
    return mid;
  } else if (arr[mid] < target) {
    return binarySearch(arr, mid + 1, end, target);
  } else {
    return binarySearch(arr, start, mid - 1, target);
  }
}

/** Test Cases **/
console.log(binarySearchAnyIndex([1, 3, 3, 3, 8], 3)); // should return 2

console.log(binarySearchAnyIndex([1, 2, 3, 6, 8], 6)); // should return 3

console.log(binarySearchAnyIndex([1, 2, 3, 6, 8], 1)); // should return 0

console.log(binarySearchAnyIndex([1, 2, 3, 6, 7, 8, 12, 14, 19, 26], 6)); // should return 3
