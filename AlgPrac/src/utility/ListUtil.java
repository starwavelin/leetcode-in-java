package utility;

import java.util.List;

public class ListUtil {
	
	public static void displayIntegers(List<Integer> ret) {
		if (ret.size() == 0) {
			System.out.println("The result set is empty!");
			return;
		}
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(" " + ret.get(i));
		}
	}
	
	public static void displayStrings(List<String> ret) {
		if (ret.size() == 0) {
			System.out.println("The result set is empty!");
			return;
		}
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(" " + ret.get(i));
		}
	}
	
}
