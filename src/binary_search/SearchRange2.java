package binary_search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Benjamin Lin
 * Same as SearchRange I except using ArrayList as the output data structure...
 */
public class SearchRange2 {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
	public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(-1);
		ret.add(-1);
		
		if (A == null || A.size() == 0) {
			return ret;
		}
		int start, end, mid;
		
		// Get the left index of target number
		start = 0;
		end = A.size() - 1;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A.get(mid) == target) {
				end = mid;
			} else if (A.get(mid) < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A.get(start) == target) {
			ret.set(0, start);
		} else if (A.get(end) == target) {
			ret.set(0, end);
		}
		
		
		// Get the right index of target number
		start = 0;
		end = A.size() - 1;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A.get(mid) == target) {
				start = mid;
			} else if (A.get(mid) < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A.get(end) == target) {
			ret.set(1, end);
		} else if (A.get(start) == target) {
			ret.set(1, start);
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Search Range II Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			testList.add(testArray[i]);
		}
		
		System.out.print("Give your target number: ");
		int target = sc.nextInt();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret = searchRange(testList, target);
		if (ret.get(0) != -1) {
			System.out.print("The number " 
				+ target + " is found from position " + ret.get(0) + " to " + ret.get(1));
		} else {
			System.out.print("The number " + target + " is NOT found!");
		}
	}
	
}
