/**************
* Problem No. : NLC 5
* Problem Name: Binary Search (Iteration)
* Problem URL :
* Date        : Oct 15 2018
* Author      : Xian Lin
***************/

function binarySearch1stIndex(arr, target) {
  let start = 0, end = arr.length - 1;
  let mid;
  while (start + 1 < end) {
    mid = start + (end - start) / 2;
    if (arr[mid] > target) {
      end = mid;
    } else if (arr[mid] < target) {
      start = mid;
    } else {
      end = mid;
    }
  }
  if (arr[start] === target) {
    return start;
  } else if (arr[end] === target) {
    return end;
  }
  return null;
}

function binarySearchLastIndex(arr, target) {
  let start = 0, end = arr.length - 1;
  let mid;
  while (start + 1 < end) {
    mid = start + (end - start) / 2;
    if (arr[mid] > target) {
      end = mid;
    } else if (arr[mid] < target) {
      start = mid;
    } else {
      start = mid;
    }
  }
  if (arr[end] === target) {
    return end;
  } else if (arr[start] === target) {
    return start;
  }
  return null;
}

function binarySearchAnyIndex(arr, target) {
  let start = 0, end = arr.length - 1;
  let mid;
  while (start + 1 < end) {
    mid = start + (end - start) / 2;
    if (arr[mid] === target) {
      return mid;
    } else if (arr[mid] < target) {
      start = mid;
    } else {
      end = mid;
    }
  }
  if (arr[start] === target) {
    return start;
  } else if (arr[end] === target) {
    return end;
  }
  return null;
}

/** Test Cases **/
console.log(binarySearch1stIndex([1, 3, 3, 3, 8], 3));

console.log(binarySearchLastIndex([1, 3, 3, 3, 8], 3));

console.log(binarySearchAnyIndex([1, 3, 3, 3, 8], 3));

console.log(binarySearchAnyIndex([1, 2, 3, 6, 8], 4));

console.log(binarySearchAnyIndex([1, 2, 3, 6, 8], -1));

console.log(binarySearchAnyIndex([1, 2, 3, 6, 8], 19));
