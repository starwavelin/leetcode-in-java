/**************
* Problem No. : NLC 4
* Problem Name: Insertion Sort
* Problem URL :
* Date        : Oct 14 2018
* Author      : Xian Lin
***************/

function insertionSort(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    let j = i + 1;
    let tmp = arr[j];
    while (j > 0 && tmp < arr[j - 1]) {
      arr[j] = arr[j - 1];
      j--;
    }
    if (j !== i + 1) {
      arr[j] = tmp;
    }
  }
  return arr;
}

/** Test Cases **/
console.log(insertionSort([9, 3, 5, 1]));

console.log(insertionSort([5, 9, 3, 1]));

console.log(insertionSort([9, 5, 3, 1]));
