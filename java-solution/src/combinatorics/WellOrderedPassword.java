package combinatorics;

import java.util.LinkedList;
import java.util.List;

/**
 * This differs from WellOrderedString
 * by 
 * #1 taking only number_of_chars_in_a_pwd (n) as parameter
 * #2 store the possible pwds in a linkedlist
 * 
 * @author Guru
 * 
 * Permutation format similar to Chapter 9 Template
 * This is actually a combination problem
 * ab, then ac, but ba doesn't count
 */

public class WellOrderedPassword {

	public static List<String> getWellOrderedPwd(int n) {
		List<String> ret = new LinkedList<String>();
		if (n <= 0) {
			return ret;
		}

		StringBuilder sb = new StringBuilder();
		generate(ret, sb, n);
		return ret;
	}

	private static void generate(List<String> ret, StringBuilder sb, int n) {
		// base case
		if (n == 0) {
			ret.add(sb.toString());
			return;
		}


		// recursive case
		char i;
		if (sb.length() == 0) {
			i = 'a';
		} else {
			i = sb.charAt(sb.length() - 1);
			i++;
		}
		for (; i < 'z'; i++) {
			sb.append(i);
			generate(ret, sb, n - 1);
			sb.setLength(sb.length() - 1);
				// coordinate with i = sb.charAt(sb.length() - 1);
				// ie. "a b c" is returned, then 
				// coordinate with i = sb.charAt(sb.length() - 1),
				// we can get "a b d".
		}

	}
	
	public static void main(String[] args) {

	}

}
