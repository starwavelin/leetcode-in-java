package array;

import java.util.Scanner;

/**
 * http://www.lintcode.com/en/problem/product-of-array-exclude-itself/
 *
 */
public class ProductWithoutItself {
	
	public static long[] productExcludeItself(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		
		int size = A.length;
		long[] ret = new long[size];
		
		// initialize ret array
		for (int i = 0; i < size; i++) {
			ret[i] = 1;
		}
		
		// Solve the left part
		for (int i = 1; i < size; i++) {
			ret[i] = ret[i-1] * A[i-1];
		}
		
		// Solve the right part
		long tmp = 1;
		for (int i = size-1; i >= 0; i--) {
			ret[i] = ret[i] * tmp;
			tmp = tmp * A[i];
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Product Without Itself Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		long[] result = productExcludeItself(testArray);
		if (result != null) {
			System.out.print("The product array without multiplying itself is: ");
			for (long l : result) {
				System.out.print(l + ", ");
			}
		} else {
			System.out.print("Please check your input array!");
		}
	}

}