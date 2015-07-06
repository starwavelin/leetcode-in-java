package math;

import java.util.Scanner;
/**
 * http://www.lintcode.com/en/problem/majority-number-ii/
 * A number occurs more than 1/3 of the array size, find this number.
 */

public class MajorityNumberII {
	
	public static int majorityNumber(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		int candidate1 = 0, count1 = 0, candidate2 = 0, count2 = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (count1 == 0) {
//				candidate1 = nums[i];
//				count1++;
//			} else if (count2 == 0) {
//				candidate2 = nums[i];
//				count2++;
//			} else if (candidate1 == nums[i]) {
//				count1++;
//			} else if (candidate2 == nums[i]) {
//				count2++;
//			} else {
//				count1--;
//				count2--;
//			}
//		}
/*
 * The above is an incorrect solution for myself as reference.
 * if we put "if (count1 == 0)" as the first constraint condition, then, 
 * for an input array like [1,1,1,1,2,2,3,3,4,4,4]
 * candidate1 becomes 1 in the first iteration, while 
 * candidate2 also becomes 1 in the second iteration ---- Logic Error!!!
 * */		

		// The following shows the correct solution -- compare 
		// candidate1 with an element in the array first.
		for (int elem : nums) {
			if (candidate1 == elem) {
				count1++;
			} else if (candidate2 == elem) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = elem;
				count1++;
			} else if (count2 == 0) {
				candidate2 = elem;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
				
		count1 = 0; count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candidate1) {
				count1++;
			} else if (nums[i] == candidate2) {
				count2++;
			} 
		} 
		return (count1 > count2) ? candidate1 : candidate2;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Majority Number II Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int result = majorityNumber(testArray);
		System.out.println("The majority number in your given int array is " + result);
	}
	
}
