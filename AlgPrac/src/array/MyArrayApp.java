package array;

public class MyArrayApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int maxSize = 100;
		MyArray myArray = new MyArray(maxSize);
		
		myArray.insert(8.0);
		myArray.insert(9.0);
		myArray.insert(6.0);
		myArray.insert(7.0);
		myArray.insert(4.0);
		myArray.insert(6.0);
		myArray.insert(5.0);
		myArray.insert(6.0);
		myArray.insert(3.0);
		
		myArray.displayArray();
		
		myArray.deleteAll(6.0);
		
		myArray.displayArray();
	}

}
