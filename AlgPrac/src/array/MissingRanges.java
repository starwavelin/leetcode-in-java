package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utility.ListUtil;
/***************************************************************************
* Problem No. : 163
* Problem Name: Missing Ranges
* Problem URL : https://leetcode.com/problems/missing-ranges/description/
* Date        : Nov 1 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
* 	Assumption:
* 		1. Duplicates are allowed
		2. Negative integers allowed
		3. The lower and upper bounds can be in [Integer.MIN_VALUE, Integer.MAX_VALUE], which is [-2147483648, 2147483647] inclusively.
		4. The lower bound and upper bound can even be within the range of the given array
	Example:
* 	Input/Output: 
* 		Input: [0,2,3,6,8,9], lower 0, upper 100
		Output: ["1","4->5","7","10->100"]
		
		Input: [-3, 0, 5, 19], lower -2, upper 9
		Output: ["-2->-1", "1->4", "5->9"]
		
		Input: [2147483647], lower 2147483647, upper 2147483647
		Output: []
		
		Input: [-2147483648, -2147483648, 0, 2147483647, 2147483647], lower -2147483648, upper 2147483647
		Output: ["-2147483647->-1", "1->2147483646"]
* 	Data Structure and Alg:
* 		Use two pointers one pass;
*  		Two pointers var cur and pointer i, 
*  			where cur starts from lower bound and is used to represent the next number right greater than nums[i],
*  			and i is the loop counter to traverse the loop
*  		When traverse
*  			if nums[i] is not in the range yet, move i till nums[i] is >= lower bound
*  			Then UNDER OVERFLOW CHECKING, increment cur to be the value right greater than nums[i]
*  			AND UNDER OVERFLOW CHECKING, append the range from cur to nums[i]-1 into res, update cur to be nums[i]+1
*  			if nums[i] equals the largest int, we are good to return the result
*  		After the loop,
*  			if cur is less than or equal to the upper bound, we wanna add the tail range from cur to upper bound.
*  		return result.
*  
* Complexity  : 
* 	Time Complexity: O(n) -- traverse the given array one pass
* 	Space Complexity: O(1) -- Just two extra pointers
* 
* meta        : tag-array, tag-two-pointers, tag-google
* 
* Pain Point: 
* 	1. Handle the overflow: each time my statement needs to update cur,
* 		I need to check overflow first before doing updating. 
* 
* Thinking:
* 	Maybe I can just use a long type to bypass all the pains of doing int overflow checking?
* Yes, I can.
***************************************************************************/
public class MissingRanges {
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
        
        // Defensive Checking
        if (lower > upper) {
            return res;
        }
        
        int cur = lower; // cur = the next number we need to find
        for (int i = 0; i < nums.length; i++) {
            // nums[i] not within the range yet
            if (nums[i] < cur) {
                continue;
            }

            // Under the overflow checking, continue to find the next one
            if (cur == nums[i] && cur < Integer.MAX_VALUE) { //考点：如何找下一个cur? 只要cur==nums[i]就要越过！
              cur++;
              continue;
            }

            // Under the overflow checking, append the missing range to result and find the next cur
            if (cur < Integer.MAX_VALUE) {
                res.add(getRange(cur, nums[i] - 1));
                cur = nums[i] + 1; 
                	//here cur could be overflowed if nums[i] == Integer.MAX_VALUE --> so once nums[i] == MV, return res
            }
            
            if (nums[i] == Integer.MAX_VALUE) { /* When nums[i] equals the largest int, good to return the result */
                return res;
            }
        }

        // Handle the case of having tail range
        if (cur <= upper) { 
            res.add(getRange(cur, upper));
        }
            
        return res;
    }
	
	/* when passing parameters in, make sure n1 <= n2 */
	public static String getRange(int n1, int n2) {
		return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}
	
	/**
	 * Solution 2：
	 *  Use type long for cur to get rid of overflow 
	 */
	public static List<String> findMissingRanges2(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
        if (lower > upper) {
            return res;
        }
        
        long cur = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < cur) {
                continue;
            }

            if (cur == nums[i]) {
              cur++;
              continue;
            }
            
            res.add(getRange2(cur, nums[i] - 1));
            cur = nums[i] + 1;
            
            if (nums[i] == Integer.MAX_VALUE) { /* When nums[i] equals the largest int, good to return the result */
                return res;
            }
        }

        if (cur <= upper) { 
            res.add(getRange2(cur, upper));
        }
            
        return res;
    }
	
	private static String getRange2(long n1, long n2) {
		return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Missing Ranges Test ***");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Enter the lower bound: ");
		int lower = sc.nextInt();
		System.out.print("Enter the upper bound: ");
		int upper = sc.nextInt();
		
		
		System.out.print("The missing ranges are: ");
		ListUtil.display(findMissingRanges(testArray, lower, upper));
		System.out.print("The missing ranges are (Sol 2): ");
		ListUtil.display(findMissingRanges2(testArray, lower, upper));
		
		
		//System.out.print(2147483647 + 1); //print out -2147483648, which is Integer.MIN_VALUE
	}
}