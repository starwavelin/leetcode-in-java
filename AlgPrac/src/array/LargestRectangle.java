package array;

import java.util.Scanner;
import java.util.Stack;

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
			for (int j = i + 1; j <= size; j++) {
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
	
	
	/**
	 * Unlike Solution1, when j is scanning the array,
	 * we keep a variable h to record the lowest height
	 * in the [i, j] range.
	 * @param height
	 * @return
	 */
	public static int solution2(int[] height) {
		int size = height.length;
		int maxArea = 0;
		
		for (int i = 0; i < size; i++) {
			int h = height[i];
			
			// Use the following loop to get the lowest height 
			// of the rectangle formed by [i, j]
			for (int j = i + 1; j <= size; j++) {
				if (height[j - 1] < h) {
					h = height[j - 1];
				}
				if ((j - i) * h > maxArea) {
					maxArea = (j - i) * h;
				}
			}
		}
		return maxArea;
	}

	
	/**
	 * Idea: enumerate the heights of the histogram first.
	 * Then, for each height, scan left and right to find the
	 * left boundary bar and the right boundary bar with 
	 * heights less than it.
	 * Calculate the area.
	 * @param height
	 * @return
	 */
	public static int solution3(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= height.length; i++) {
			int cur = (i == height.length) ? -1 : height[i];  
						// -1 is the dummy bar in the rightmost of histogram
			while (!stack.isEmpty() && cur <= height[stack.peek()]) {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, h * w);
			}
			stack.push(i);
		}
		return maxArea;
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
		
		System.out.print("Give your Solution (1, 2, or 3): ");
		
		int method = sc.nextInt();
		int result = 0;
		switch (method) {
			case 1:
				result = solution1(testArray);
				break;
			case 2:
				result = solution2(testArray);
				break;
			case 3:	
				result = solution3(testArray);
				break;
			default:
				System.out.println("Please check your input for the method number!");
				break;
		}
		System.out.println("The largest rectangle area based on your given int array is " + result);
	}
}