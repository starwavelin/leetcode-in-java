package binary_search;

import java.util.Scanner;
/**
 * 
 * Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 *
 */
public class SearchInsertPosition {
	
	/** 
     * param nums : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public static int searchInsertPosition(int[] nums, int target) {
    	// Find first position >= target, return it; 
    	// no position >= target, return nums.length;
    	if (nums == null || nums.length == 0) {
    		return 0;	// if empty array, insert target at pos 0
    	}
    	
    	int start, end, mid;
    	start = 0;
    	end = nums.length -1;
    	while (start + 1 < end) {
    		mid = start + (end - start) / 2;
    		if (nums[mid] == target) {
    			return mid;
    		} else if (nums[mid] < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (nums[start] >= target) {
    		return start;
    	} else if (nums[end] >= target) {
    		return end;
    	} else {
    		return nums.length;
    	}
    }
    
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Search Insert Position Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Give your target number: ");
		int target = sc.nextInt();
		int result = searchInsertPosition(testArray, target);
		if (result != -1) {
			System.out.print("The number " 
				+ target + " is found OR should be inserted at position " + result);
		} else {
			System.out.print("Check your input array!!");
		}
	}
}
