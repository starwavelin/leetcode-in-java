package dp;

import java.util.Scanner;

/**
 * This class does
 * 1) Calculate the length of the Longest Increasing Subsequence
 * for a given integer array
 * 
 * 2) Calculate the length of the Longest Increasing Subsequence
 * at any ending position for a given array
 * 
 * @author Guru
 *
 */


public class LIS_EndingPosition {

	public static void main(String[] args) {
		System.out.println("*** Welcome to the Longest Increasing Subsequence ***\n");
		System.out.print("Please input a sequence of integers: ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String[] s2 = s.split(" ");
		
		int n = s2.length; 
		int[] a = new int[n];	
		int[] b = new int[n];
		for(int i = 0; i < a.length; i++){
			a[i] = Integer.parseInt(s2[i]);		
			b[i] = 0;
		}
		
		LISdynamic(a, b, n);
		int maxLength = maxL(n, b);
		System.out.println("The Longest Increasing Subsequence has length: " + maxLength);
		
		// Case: position must be the ending position in LIS
		System.out.print("Enter the ending position that you wanna check its LIS: ");
		int pos = input.nextInt();
		int maxEndPos = b[pos];
		System.out.println("The Longest Increasing Subsequence " +
				"including ending position " + pos + " is: " + maxEndPos);
	}

}
