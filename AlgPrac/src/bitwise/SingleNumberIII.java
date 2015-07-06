package bitwise;

import java.util.Scanner;
/**
 * 
 * http://www.lintcode.com/en/problem/single-number-iii/
 * In an int array with 2n+2 numbers, only two distinct numbers occur only once, others
 * occur exactly twice. Find the two distinct numbers.
 * 
 * Method: 
 * Divide this problem into a 2n+1 problem, and then use the method in SingleNumberI.
 * 
 */
public class SingleNumberIII {
	
	public static int[] singleNumber(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		
		int[] ret = new int[2];
		ret[0] = ret[1] = 0;
		int n = 0;
		for (int elem : nums) {
			n = n ^ elem;
		}
		
		// Divide the two numbers we wanna obtain into two diff groups
		n = n & (~(n-1));
		for (int elem : nums) {
			if ((elem & n) != 0) {
				ret[0] = ret[0] ^ elem;
			} else {
				ret[1] = ret[1] ^ elem; 
			}
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Single Number III Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int[] results = singleNumber(testArray);
		System.out.println("The single number in your given int array are " + results[0] 
				+ " and " + results[1]);
	}
}
