package utility;

import java.util.List;

public class ListUtil {
	
	public static void display(List res) {
		if (res.size() == 0) {
			System.out.println("The result set is empty!");
			return;
		}
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" " + res.get(i));
		}
		System.out.println(); /* separating output of test cases */
	}
	
	public static void displayIntegers(List<Integer> ret) {
		if (ret.size() == 0) {
			System.out.println("The result set is empty!");
			return;
		}
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(" " + ret.get(i));
		}
		System.out.println();
	}
	
	public static void displayStrings(List<String> ret) {
		if (ret.size() == 0) {
			System.out.println("The result set is empty!");
			return;
		}
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(" " + ret.get(i));
		}
		System.out.println();
	}
	
}
