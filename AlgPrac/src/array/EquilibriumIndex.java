package array;

import java.util.Scanner;

/**
 * Get the equilibrium index from an integer array.
 * Return the index where the sum of its left elements 
 * 	equals the sum of its right elements; itself shall be eliminated.
 * 
 * Note: an integer array may have multiple equilibrium indexes,
 * for this problem, given one of them will be fine.
 */

public class EquilibriumIndex {
	
	/**
	 * This method returns the first equilibrium index found 
	 * 	in the given integer array
	 * @param A: the given integer array
	 * @return the first equilibrium index
	 */
	public static int getEquilibriumIndex(int[] A) {
		int ret = -1;
		if (A == null || A.length == 0) {
			return ret;
		}
		
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < A.length; i++) {
			rightSum += A[i];
		}
		
		for (int i = 0; i < A.length; i++) {
			int tmpRight = rightSum - A[i];
			if (leftSum == tmpRight) {
				ret = i;
				break;
			} else {
				leftSum += A[i];
				rightSum = tmpRight;
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Equilibrium Index Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int result = getEquilibriumIndex(testArray);
		if (result != -1) {
			System.out.print("The equilibrium of the given array is: " + result);
		} else {
			System.out.print("The given array doesn't have an equilibrium index!");
		}
	}
}
