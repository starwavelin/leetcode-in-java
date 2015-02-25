package arraysAndStrings;

import java.util.Scanner;

/**
 * Given a sorted integer array, 
 * find the indices of the two numbers whose sum is the closest one
 * to the target integer. If there are multiple solutions, 
 * just returning the first pair of indices you found is fine.
 * @author Benjamin Lin
 *
 */

public class TwoSumClosestToTarget {
	
	// input array: 2, 4, 8, 10, 12
	// target value: 17
	// result: indices of number 4, 12 or 8, 10; return one of them is sufficient.
	
	// input array: 2, 4, 8, 10, 12, 20
	// target value: 17
	// result: indices of number 4, 12 or 8, 10; return one of them is sufficient.

	public static int[] twoSumClosest(int[] input, int target) {
		if (input.length < 2 || input == null) {
			return null;
		}
		
		int[] ret = new int[2];
		int start = 0;
		int end = input.length -1;
		int diff = Integer.MAX_VALUE; 
			
		while (start + 1 < end) { // writing this way you can always avoid infinity loop
			if (input[start] + input[end] < target) {
				if (Math.abs(input[start] + input[end] - target) < diff) {
					diff = Math.abs(input[start] + input[end] - target);
					start++;
				} else {
					ret[0] = start;
					ret[1] = end + 1;
					return ret;
				} 
			}	else if (input[start] + input[end] > target) {
				if (Math.abs(input[start] + input[end] - target) < diff) {
					diff = Math.abs(input[start] + input[end] - target);
					end--;
				} else {
					ret[0] = start - 1;
					ret[1] = end;
					return ret;
				}
			}	else { // when input[start] + input[end] == target
				ret[0] = start; 
				ret[1] = end;
				return ret;
			}
		}
		
		// when start and end are next to each other, evaluate the diff again
		if (Math.abs(input[start] + input[end] - target) < diff) {
			ret[0] = start; 
			ret[1] = end;			
		}
		return ret;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's TwoSumClosestToTarget Test ***");
		
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
		int[] result = twoSumClosest(testArray, target);
		if (result != null) {
			System.out.print("The two numbers that are closest to the target " 
				+ target + " have indices " + result[0] + " and " + result[1]);
		} else {
			System.out.print("Please check your input array!");
		}
	}
}
