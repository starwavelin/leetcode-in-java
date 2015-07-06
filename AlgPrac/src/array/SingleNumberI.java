package array;

import java.util.Scanner;
/**
 * 
 * http://www.lintcode.com/en/problem/single-number/
 *
 */

public class SingleNumberI {
	
	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			n = n ^ nums[i];
		}
		return n;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Largest Rectangle in Histogram Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int result = singleNumber(testArray);
		System.out.println("The single number in your given int array is " + result);
	}
	
}
