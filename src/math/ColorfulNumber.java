package math;

import java.util.HashSet;

/**
 * Basically two cases,
 * Case 1: cumulative color digit product O(n)
 * Case 2: product of adjacent color digits O(n^2)
 * @author Guru
 * 
 */

public class ColorfulNumber {

	private static boolean colorfulNum(int num) {
		if (num < 0) {
			return false;
		}
		String str = String.valueOf(num);
		if (str.length() < 2) {
			return true;
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		// case 1
		int color = str.charAt(0) - '0';
		set.add(color); 	// insert the 1st color digit
		
		for (int i = 1; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			color = color * n;
			if (set.contains(color)) {
				return false;
			} else {
				set.add(color);
			}
		}
		
		// case 2
		for (int i = 1; i < str.length(); i++) {
			color = str.charAt(i) - '0';
			if (set.contains(color)) {
				return false;
			} else {
				for (int j = i + 1; j < str.length(); j++) {
					int n = str.charAt(j) - '0';
					color = color * n;
					if (set.contains(color)) {
						return false;
					} else {
						set.add(color);
					}
				}
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's ColorfulNumber Test ***");
		
		System.out.println(colorfulNum(3245));
		System.out.println(colorfulNum(326));
	}

}
