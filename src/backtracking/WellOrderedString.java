package backtracking;

public class WellOrderedString {
	
	private static int stringCount = 0;
	
	private static void generateWellOrderedString(String currentStr, int charsLeft) {
		// Base case		
		if (charsLeft == 0) {
			System.out.println(currentStr);
			stringCount++;
		}
		
		// recursive case
		char i;
		if (currentStr.isEmpty()) {
			i = 'a'; // starting from alphabet 'a'
		} else {
			// i = (char) (currentStr.charAt(currentStr.length() - 1) + 1);
			i = currentStr.charAt(currentStr.length() - 1);
			i++;
		}
		for (; i <= 'z'; i++) {
			generateWellOrderedString(currentStr + i, charsLeft - 1);
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's WellOrderedString Test ***");
		generateWellOrderedString("", 2);
		System.out.println("Total such strings are: " + stringCount);
	}

}
