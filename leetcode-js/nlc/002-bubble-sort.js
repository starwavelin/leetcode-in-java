/**************
* Problem No. : NLC 2
* Problem Name: Bubble Sort
* Problem URL :
* Date        : Oct 13 2018
* Author      : Xian Lin
***************/

function bubbleSort(arr) {
  for (let i = arr.length - 1; i > 0; i--) {
    for (let j = 1; j <= i; j++) {
      if (arr[j] < arr[j-1]) {
        swap(arr, j, j-1);
      }
    }
  }
  return arr;
}

function swap(arr, i, j) {
  let t = arr[i];
  arr[i] = arr[j];
  arr[j] = t;
}

/** Test Cases **/
console.log(bubbleSort([9, 3, 5, 1]));

console.log(bubbleSort([5, 9, 3, 1]));

console.log(bubbleSort([9, 5, 3, 1]));
