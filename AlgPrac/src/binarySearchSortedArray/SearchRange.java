package binarySearchSortedArray;

import java.util.Scanner;

public class SearchRange {
	
	/** 
     *@param nums : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public static int[] searchRange(int[] nums, int target) {
    	int[] ret = new int[2];
    	ret[0] = ret[1] = -1;
    	
        if (nums == null || nums.length == 0) {
        	return ret;
        }
        
        int start, end, mid;
        
        // Find the left bound
        start = 0; 
        end = nums.length - 1;
        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (nums[mid] == target) {
        		end = mid;
        	} else if (nums[mid] < target) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
    	if (nums[start] == target) { // when searching the left bound, check start first.
    		ret[0] = start;
    	} else if (nums[end] == target) {
    		ret[0] = end;
    	}
    	
    	// Find the right bound
    	start = 0; 
        end = nums.length - 1;
    	while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (nums[mid] == target) {
        		start = mid;
        	} else if (nums[mid] < target) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
    	if (nums[end] == target) {	// when searching the right bound, check end first.
    		ret[1] = end;
    	} else 	if (nums[start] == target) {
    		ret[1] = start;
    	}
    	
    	return ret;
    }
		
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Search Range Test ***");
		
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
		int[] result = new int[2];
		result = searchRange(testArray, target);
		if (result[0] != -1) {
			System.out.print("The number " 
				+ target + " is found from position " + result[0] + " to " + result[1]);
		} else {
			System.out.print("The number " + target + " is NOT found!");
		}
	}
	
}
