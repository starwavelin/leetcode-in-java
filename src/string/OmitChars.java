package string;

import java.util.Scanner;

/**
 * Given an input string, let's say "abcdefg"; I want you to omit letter a and d
 * so that the output string should be "bcefg".
 *
 */
public class OmitChars {

	public static String getNewStr(String input) {
		if (input == null || input.length() == 0) {
			return null;
		}

		String ret = "";
		int size = input.length();
		for (int i = 0; i < size; i++) {
			if (input.charAt(i) == 'a' || input.charAt(i) == 'd') {
				continue;
			}
			ret += input.charAt(i);
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Omit Character Test ***");

		System.out.print("Give an input String: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		String ret = getNewStr(s);
		if (ret != null) {
			System.out
					.println("The output string after removing letter a and d is: "
							+ ret);
		} else {
			System.out.println("Please check your input string!!");
		}
	}
}
