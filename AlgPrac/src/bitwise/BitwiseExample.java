package bitwise;

public class BitwiseExample {

	public static void main(String[] args) {
		/* 60 is 0011 1100; 13 is 0000 1101 in binary */
		int a = 60, b = 13; 
		
		System.out.println("a & b becomes " + (a & b)); // should give 12
		
		System.out.println("a | b becomes " + (a | b)); // should give 61
		
		/* XOR == 不进位加法 */
		System.out.println("a ^ b becomes " + (a ^ b)); // should give 49
		
		/* Negate: 按位非操作： cuz ~ gives the new binary in 2's complement 其实就是找一个数的在数轴另一端的对称点 */
		System.out.println("~a becomes " + ~a); 	// should give -61 
		System.out.println("~b becomes " + ~b); 	// should give -14
		
		System.out.println("a << 2 becomes " + (a << 2)); // should give 240 对正整数而言相当于乘以 (2^2=) 4
		System.out.println("a >> 2 becomes " + (a >> 2)); // should give 15  对正整数而言相当于除以 (2^2=) 4
		
		int x = (int) ((-1)*Math.pow(2, 31));
		System.out.println("x is " + x); // -2147483648
		x = x << 1;
		System.out.println("x is " + x); // 0
		
		/* Compare >> (right shift) and >>> (logical right shift) */
		int y = -128; // -128
		System.out.println(y >> 1); // negative number -128/2 = -64
		System.out.println(y >>> 1); // positive number is it Math.abs(-128/2) = 64 ? NO!! It should be Integer.MAX_VALUE + 1 + (-128 / 2)
	}
	
}
