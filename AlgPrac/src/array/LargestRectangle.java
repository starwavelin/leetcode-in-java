package array;

import java.util.Scanner;

/**
 * http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
 * Largest Rectangle in Histogram
 * Solution 1: O(n^3)
 * Solution 2: O(n^2)
 * Solution 3: O(n)
 * @author Guru
 *
 */

public class LargestRectangle {
	 
	
	public static int solution1(int[] height) {
		int size = height.length;
		int maxArea = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size + 1; j++) {
				int h = height[i];
				
				// This loop is for finding the lowest height 
				// in the bars of (j-i) region
				for (int k = i; k < j; k++) {
					if (height[k] < h) {
						h = height[k];
					}
				}
				
				if ((j - i ) * h > maxArea) {
					maxArea = (j - i) * h;
				}
			}
		}
		return maxArea;
	}
	
//	public int solution2(int[] height) {
//		
//	}
//	
//	public int solution3(int[] height) {
//		
//	}
	
	
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
		
		System.out.print("Give your Solution (1, 2, or 3): ");
		
		int method = sc.nextInt();
		int result = 0;
		switch (method) {
			case 1:
				result = solution1(testArray);
				break;
//			case 2:
//				result = solution2(testArray);
//				break;
//			case 3:	
//				result = solution3(testArray);
//				break;
			default:
				System.out.println("Please check your input for the method number!");
				break;
		}
		System.out.println("The largest rectangle area based on your given int array is " + result);
	}
}