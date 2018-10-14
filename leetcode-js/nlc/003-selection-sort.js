/**************
* Problem No. : NLC 3
* Problem Name: Selection Sort
* Problem URL :
* Date        : Oct 14 2018
* Author      : Xian Lin
***************/

function selectionSort(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    let minIndex = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j;
      }
    }
    if (minIndex !== i) {
      swap(arr, i, minIndex);
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
console.log(selectionSort([9, 3, 5, 1]));

console.log(selectionSort([5, 9, 3, 1]));

console.log(selectionSort([9, 5, 3, 1]));
