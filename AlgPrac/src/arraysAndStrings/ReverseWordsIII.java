package arraysAndStrings;

import java.util.Scanner;

/**
 * If the words don't have leading or trailing spaces and 
 * words are separated by a single space,
 * we can do reverse words in-place without
 * allocating extra space.
 * 
 * If the input word has leading or trailing spaces,
 * the result would also contain leading/trailing spaces.
 * For the result version of result still not containing l/t spaces even the input has,
 * see ReverseWordsIV.
 * @author Benjamin Lin
 *
 */
public class ReverseWordsIII {
	
	/**
	 * In this approach, we reverse the whole char[] first,
	 * then we reverse each individual word.
	 * @param s
	 * @return
	 */
	public static String reverseWords(char[] s) {
		
		reverse(s, 0, s.length);
		//System.out.println(s);
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}
		
		String ret = "";
		for (int i = 0; i < s.length; i++) {
			ret += s[i];
		}
		return ret;		
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
		System.out.println("*** Welcome to Ben's Reverse Words Version III Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your string array, \n" +
				"leave each word by space: ");
		String strs = sc.nextLine();
		char[] s = strs.toCharArray();
		
		String result = reverseWords(s);
		if (result != null) {
			System.out.print("The reversed words are " + result);
		} else {
			System.out.print("Please check your input string!");
		}
	}
}
