package string;

import java.util.Scanner;

public class StrStr {

	public static int strStr(String source, String target) {
		if (target == null || target == "" || target.length() > source.length())
			return -1;
		int i, j;	// the result should return i or -1
		for (i = 0; i < source.length() - target.length() + 1; i++) {
			for (j = 0; j < target.length(); j++) {
				if (source.charAt(i + j) != target.charAt(j)) {
					break;
				}
			}
			if (j == target.length())
				return i;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's String String Test ***");
		
		Scanner sc = new Scanner(System.in);		
		System.out.print("Input your source string: ");
		String src = sc.nextLine();
		System.out.print("Input your target string: ");
		String tgt = sc.nextLine();
		
		int ret = strStr(src, tgt);
		if (ret != -1) {
			System.out.println("At the index of " + ret + " of the source string, "
					+ "they match");
		} else {
			System.out.println("The target string cannot be found in the source string.");
		}
	}
}
