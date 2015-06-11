package arraysAndStrings;

import java.util.Scanner;

/**
 * Not much different from ReverseWordsIII, except the argument of 
 * reverseWords() is String s instead of char[] s this time.
 * @author Guru
 *
 */
public class ReverseWordsIV {
	
	public static String reverseWords(String s) {
		if (s == null || !s.contains(" ")) {
            return s;
        }
        char[] ret = s.toCharArray();
        reverse(ret, 0, ret.length);
        for (int i = 0, j = 0; j <= ret.length; j++) {
            if (j == ret.length || ret[j] == ' ') {		
            		// the order of j==ret.length and ret[j]==' ' matters!!! 
                reverse(ret, i, j);
                i = j + 1;
            }
        }
        String result = new String(ret);
        return result;		
	}
	
	/**
	 * Centro-symmetrically reverse a char[] (String)
	 * or a word in the char[]
	 * @param src the input char[]
	 * @param start the start position of the source char[] to be reversed
	 * @param end the end position of the source char[] to be reversed
	 * @return
	 */
	private static void reverse(char[] src, int start, int end) {
		for (int i = 0; i < (end - start) / 2; i++) {
			char tmp = src[start + i];
			src[start + i] = src[end - i - 1];
			src[end - i - 1] = tmp;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Reverse Words Version IV Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your string array, \n" +
				"leave each word by space (no leading or trailing spaces!): ");
		String strs = sc.nextLine();
				
		String result = reverseWords(strs);
		if (result != null) {
			System.out.print("The reversed words are " + result);
		} else {
			System.out.print("Please check your input string!");
		}
	}
	
}
