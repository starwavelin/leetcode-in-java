package binarySearch;

import java.util.Scanner;

/**
 * Search the minimum in a rotated array; assume no duplicates.
 * For example, [4, 5, 6, 7, 0, 1, 2]
 * The min is 0 in position 4
 * http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/
 */

public class SearchMinRotatedArray {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
        	    return -1;
        }
        
        int start = 0, end = nums.length - 1, mid;
        if (nums[start] < nums[end]) {
        	    return nums[start];
        }
        while (start + 1 < end) {
        	    mid = start + (end - start) / 2;
        	    if (nums[mid] > nums[start]) {
        	        start = mid;
        	    } else {
        	        end = mid;
        	    }
        }
        if (nums[start] < nums[end]) {
        	    return nums[start];
        } else {
        	    return nums[end];
        }
    }
	
    public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Search Minimum in Rotated Array Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer rotated array, \n" + "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int result = findMin(testArray);
		if (result != -1) {
			System.out.print("The min in this rotated array is " + result);
		} else {
			System.out.print("Check Your Input Please!!");
		}
	}
}