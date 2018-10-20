/**************
* Problem No. : 4
* Problem Name: Median of Two Sorted Arrays
* Problem URL : https://leetcode.com/problems/median-of-two-sorted-arrays/description/
* Date        : Oct 20 2018
* Author      : Xian Lin
***************/

/* Naive solution O(m+n) */
var findMedianSortedArrays = function(nums1, nums2) {
    const arr = merge(nums1, nums2);
    const len = arr.length;
    if (len % 2 === 0) {
        return (arr[Math.floor((len - 1) / 2)] + arr[len / 2]) / 2;
    } else {
        return arr[Math.floor((len - 1) / 2)];
    }
};

var merge = function(nums1, nums2) {
    let arr = [];
    let i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
        const num = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        arr.push(num);
    }
    while (i < nums1.length) {
        arr.push(nums1[i++]);
    }
    while (j < nums2.length) {
        arr.push(nums2[j++]);
    }
    return arr;
}

/* @TODO O(log(m+n)) */
