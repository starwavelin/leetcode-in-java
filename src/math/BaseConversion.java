package math;

import java.util.Scanner;


/**
 * From Decimal to other base formats
 * @author Benjamin Lin
 *
 */
public class BaseConversion {

	private static String getBinary(int num) {
		String ret = "";
		if (num==0) {
			return "0";
		}
		while (num != 0) {
			ret = Integer.toString(num % 2) + ret;
			num /= 2;
		}
		return ret;
	}
	
	private static String getOctal(int num) {
		String ret = "";
		if (num==0) {
			return "0";
		}
		while (num != 0) {
			ret = Integer.toString(num % 8) + ret;
			num /= 8;
		}
		return ret;
	}
	
	private static String getHexa(int num) {
		String ret = "";
		if (num==0) {
			return "0";
		}
		while (num != 0) {
			if (num % 16 == 10) {
				ret = "A" + ret;
			} else if (num % 16 == 11) {
				ret = "B" + ret;
			} else if (num % 16 == 12) {
				ret = "C" + ret;
			} else if (num % 16 == 13) {
				ret = "D" + ret;
			} else if (num % 16 == 14) {
				ret = "E" + ret;
			} else if (num % 16 == 15) {
				ret = "F" + ret;
			} else {			
				ret = Integer.toString(num % 16) + ret;
			}
			num /= 16;
		}
		return ret;
	}
	
	/**
	 * Converts a hexadecimal number to
	 * a decimal number
	 * @param hex
	 * @return
	 */
	private static int getDecimal(String hex) {
		int hexLength = hex.length();
		int num = 0; 
		for (int i = 0; i < hexLength; i++) {
			if (hex.charAt(i) == 'A') {
				num += 10 * Math.pow(16, hexLength - 1 - i);
			} else if (hex.charAt(i) == 'B') {
				num += 11 * Math.pow(16, hexLength - 1 - i);
			} else if (hex.charAt(i) == 'C') {
				num += 12 * Math.pow(16, hexLength - 1 - i);
			} else if (hex.charAt(i) == 'D') {
				num += 13 * Math.pow(16, hexLength - 1 - i);
			} else if (hex.charAt(i) == 'E') {
				num += 14 * Math.pow(16, hexLength - 1 - i);
			} else if (hex.charAt(i) == 'F') {
				num += 15 * Math.pow(16, hexLength - 1 - i);
			} else {
			  num += (hex.charAt(i) - '0') * Math.pow(16, hexLength - 1 - i);
			}
		}
		return num;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's BaseConversion Test ***");
		
		Scanner sc = new Scanner(System.in);
//		System.out.print("Input a decimal number: ");
//		int num = sc.nextInt();
//		
//		String binary = getBinary(num);
//		String octal = getOctal(num);
//		String hexadecimal = getHexa(num);
//		System.out.println("Its binary form is: " + binary);
//		System.out.println("Its octal form is: " + octal);
//		System.out.println("Its hexadecimal form is: " + hexadecimal);
//		
		
		System.out.print("\nInput a hexadecimal number (0-9A-F): ");
		String hex = sc.next();
		int decimal = getDecimal(hex);
		System.out.println("Its decimal form is: " + decimal);
	}

}
