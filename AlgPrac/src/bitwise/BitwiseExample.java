package bitwise;

public class BitwiseExample {

	public static void main(String[] args) {
		int a = 60, b = 13; 
			// 60 is 0011 1100; 30 is 0000 1101 in binary
		
		System.out.println("a & b becomes " + (a & b)); // should give 12
		System.out.println("a | b becomes " + (a | b)); // should give 61
		System.out.println("a ^ b becomes " + (a ^ b)); // should give 49
		System.out.println("~a becomes " + ~a); 	// should give -61 
					// cuz ~ gives the new binarly in 2's complement
		
		System.out.println("a << 2 becomes " + (a << 2)); // should give 240
		System.out.println("a >> 2 becomes " + (a >> 2)); // should give 15
		
	}

}
