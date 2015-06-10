package binarySearchSortedArray;

import java.util.Scanner;
/**
 * Search the minimum in a rotated array; duplicates allowed.
 * For example, [4, 4, 5, 6, 7, 0, 1, 2]
 * The min is 0 in position 5
 * http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array-ii/
 * 
 * We can only use O(n) to solve it. Recall a black box test, where we assume we have n-1 2's and only one 1.
 */
public class SearchMinRotatedArrayII {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
	
    public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Search Minimum in Rotated Array II Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer rotated array, \n" +
				"leave each number by space: ");
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
