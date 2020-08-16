package array;

/**
 * This class demonstrates my customized Array data structure, having 5 methods:
 * - find
 * - insert 
 * - delete1stOccurrence
 * - deleteAll -- 值得考的
 * - displayArray
 * 
 * @author Guru
 */

public class MyArray {
	
	private int[] array;
	private int numElements;	// the actual size of the array
	
	public MyArray(int max) {
		array = new int[max];	
			// max - the maximum size of the array, 
			// should be greater than or equal to the actual number of elements in the array
		numElements = 0;
	}
	
	/**
	 * Search to determine if an element is in the given array
	 * @param searchKey the element to examine
	 * @return true if it is in; false if not
	 */
	public boolean find(double searchKey) {
		for (int j = 0; j < numElements; j++) { 
			if (array[j] == searchKey)
				return true;
		}
		return false;
	}
	
	/**
	 * Insert an element into the array
	 * @param value
	 */
	public void insert(int value) {
		if (numElements < array.length) {
			array[numElements] = value;
			numElements++;
		}
	}
	
	/**
	 * Delete an element from the array
	 * @param value -- the element we want to remove from the array
	 * @return true if we find the value and delete it; false otherwise.
	 * 
	 * Simple single pointer implementation
	 */
	public boolean delete1stOccurrence(int value) {
		int j;
		for (j = 0; j < numElements; j++) { 
			if (array[j] == value)
				break;
		}
		if (j == numElements) {
			return false;
		} else {
			while (j < numElements) {
				array[j] = array[j + 1];
				j++;
			}
			numElements--;	// decrement numElements
			return true;
		}
	}
	
	/**
	 * Delete all the target values in the current array
	 * @param value -- the target value to be deleted
	 * 
	 * Algorithm:
	 * Utilize extra space and make the original array reference pointing to the newly constructed array
	 * so the original array will be Garbage Collected.
	 */
	public void deleteAll(double value) {
		int numOfToDeleteValue = countTargetValue(value);
		if (numOfToDeleteValue == 0)
			return;
		int[] help = new int[numElements - numOfToDeleteValue];
		int index = 0;
		for (int i = 0; i < numElements; i++) { //注意，我这个class中array的length是max,所以，这里要用有numElemnts的looping
			if (array[i] != value) {
				help[index++] = array[i];
			}
		}		
		array = help;
		//Update numElements to make sure the displayArray() works correctly
		numElements -= numOfToDeleteValue;
	}
	
	private int countTargetValue(double value) {
		int count = 0;
		for (double num: array) {
			if (num == value)
				count++;
		}
		return count;	
	}
	
	/*
	 * two-pointer approach successfully
	 * Handled consecutive targeting values but it doesn't handle the single targeting value case */
//	public void deleteAllIncorrect(double value) {
//		int j = 0, k = 1, origNumELements = numElements;
//		while (j < origNumELements && k < array.length) {
//			if (array[j] == value) {
//				numElements--;
//				while (array[k] == value && k < array.length) {
//					k++;
//				}
//				array[j] = array[k];
//			}
//			j++; k++;
//		}
//	}
	
	/**
	 * Display the current array
	 */
	public void displayArray() {
		for (int i = 0; i < numElements; i++) {
			System.out.print(array[i] + "   ");
		}
		System.out.println();
	}
	
	public int getSize() {
		return numElements;
	}
	
	public int getIndex(int index) {
		return array[index];
	}
	
	public static void main(String[] args) {
		// Test 1
		MyArray myArray = new MyArray(20);
		
		myArray.insert(8);
		myArray.insert(9);
		myArray.insert(6); //
		myArray.insert(7);
		myArray.insert(4); 
		myArray.insert(6); //
		myArray.insert(6); //
		myArray.insert(5);
		myArray.insert(6);
		myArray.insert(3);
		
		myArray.displayArray();
		
//		myArray.delete1stOccurrence(4);
		myArray.deleteAll(6);
		
		myArray.displayArray();
		
		// Test 2
		
		
		// Test 3
	}
}