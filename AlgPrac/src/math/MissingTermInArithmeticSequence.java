package math;

import java.io.*;
import java.util.*;

public class MissingTermInArithmeticSequence {
	
	public static void main(String[] args) {
		
		/* DEAL WITH INPUT */		
		Scanner sc = new Scanner(System.in);
		//System.out.println("Please give the total number in the sequence: ");
		int n = Integer.parseInt(sc.nextLine()); // total numbers in an int array
		//System.out.println("Please provide the number sequence, sepearate by a space: ");
		String str = sc.nextLine();
		String[] strArray = str.split(" ");		
		
		int[] array = new int[n];
		int sum = 0;
		
		for (int i = 0; i < strArray.length; i++) {
			array[i] = Integer.parseInt(strArray[i]);
			//System.out.print(array[i] + " ");
			sum += array[i];
		}
		
		/* GET THE MISSTING TERM */
		int theorySum = (array[0] + array[n-1]) * (n+1) / 2;
		int missing = theorySum - sum;
		System.out.println("sum is " + sum);
		System.out.println("theorySum is " + theorySum);
		
		System.out.println(missing);
	}
}
