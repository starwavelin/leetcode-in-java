package math;

/***************************************************************************
* 
* meta        : tag-math, tag-bitwise
***************************************************************************/
public class PowerOf4 {

	/**
	 * Solution 1: while loop mod to test remainder and divide to get quotient
	 * Solution 2: Base change formula
	 * Solution 3: similar to the SC3 of isPowerOf2, we just add one more condition
	 * 	the power of 4 - 1 can always be divided by 3.
	 * Following solution is Solution 3.	 
	 */
	public static class SC {
		public boolean isPowerOf4(int num) {
			if (num <= 0) {
				return false;
			}
			return (num & (num - 1)) == 0 && (num - 1) % 3 == 0 ? true : false; //bit operands should always be enclosed by () in java.
		}
	}
	
	public static void main(String[] args) {
		SC sc = new SC();
		int n1 = -4, n2 = 4, n3 = 8, n4 = 16;
		System.out.println("Is power of 4? " + sc.isPowerOf4(n1) + " " + sc.isPowerOf4(n2) 
			+ " " + sc.isPowerOf4(n3) + " " + sc.isPowerOf4(n4)); // false, true, false, true
	}
}
