/**************
* Problem No. : S136 (Similar to LeetCode 136)
* Problem Name: Single Number
* Problem URL : 给你n个自然数，从1到n-1，其中的某一个数出现两次，其余的数都是只出现一次。返回出现两次的那个数。
* Date        : Oct 20 2018
* Author      : Xian Lin
***************/

/* Solution 1, time complexity o(n), space complexity: O(n) */
function getSingleNumber(nums) {
  let map = {};
  for (let key of nums) {
    map[key] = map[key] ? map[key] + 1 : 1;
    if (map[key] === 2) {
      return key;
    }
  }
  return null;
}

/* Solution 2, time complexity o(nlogn), space complexity: O(1) */
function getSingleNumber2(nums) {
  nums.sort();
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] == nums[i-1]) {
      return nums[i];
    }
  }
  return null;
}

/* Test Cases */
console.log(getSingleNumber([1, 5, 2, 3, 2])); // should return 2

console.log(getSingleNumber2([1, 5, 4, 3, 4])); // should return 4
