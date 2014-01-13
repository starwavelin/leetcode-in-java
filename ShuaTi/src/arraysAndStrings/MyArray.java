package arraysAndStrings;

/**
 * This class of Array has 4 methods:
 * find, insert, delete, displayArray
 * @author Guru
 *
 */

public class MyArray {
	
	private double[] array;
	private int numElements;	// the actual size of the array
	
	public MyArray(int max) {
		array = new double[max];	// max - the maximum size of the array
		numElements = 0;
	}
	
	/**
	 * Find if an element is in the given array
	 * @param searchKey the element to examine
	 * @return true if it is in; false if not
	 */
	public boolean find(double searchKey) {
		int j;
		for (j = 0; j < numElements; j++) { 
			if (array[j] == searchKey)
				break;
		}
		if (j == numElements)
			return false;
		else
			return true;
	}
	
	/**
	 * Insert a value to the array
	 * @param value
	 */
	public void insert(double value) {
		if (numElements < array.length) {
			array[numElements] = value;
			numElements++;
		}
	}
	
	/**
	 * Delete the value in the array
	 * @param value 
	 * @return true if we find the value and delete it; false otherwise.
	 */
	public boolean delete(double value) {
		int j;
		for (j = 0; j < numElements; j++) { 
			if (array[j] == value)
				break;
		}
		if (j == numElements)
			return false;
		else {
			for (int k = j; k < numElements; k++) {
				array[k] = array[k+1];	// move higher ones down				
			}
			numElements--;	// decrement the size by 1
			return true;
		}
	}
	
	/**
	 * Display the current array
	 */
	public void displayArray() {
		for (int j = 0; j < numElements; j++) {
			System.out.print(array[j] + "   ");
		}
		System.out.println();
	}
	
	/**
	 * Delete all the target values in the current array
	 * @param value
	 */
	public void deleteAll(double value) {
		int j;
		for (j = 0; j < numElements; j++) {
			if (array[j] == value) {
				for (int k = j; k < numElements; k++) {
					array[k] = array[k+1];
				}
				numElements--;	
			}
		}
	}
	
}
