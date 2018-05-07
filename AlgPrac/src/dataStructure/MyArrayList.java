package dataStructure;

import java.util.Arrays;

/**
 * @author xianlin
 * Interview Q: Design Your Own ArrayList
 * 
 * Assuming my ArrayList takes integers as its values
 * 
 * 1. The underground implementation of ArrayList is an array
 * 2. Need to have 4 major functions
 * 	1. add(int element) -- add() is the most complex one cuz it needs to consider when full, resize the array
 * 	2. get(int index)
 * 	3. set(int index, int element)
 * 	4. remove(int index) 
 * 3. When resizing, the growth rate is 1.5
 * @param <E>
 * 
 * Reference: http://yikun.github.io/2015/04/04/Java-ArrayList%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
 */
public class MyArrayList {
	
	private int[] data;
	private int capacity;
	
	// The size of the arrayList (number of elements it contains)
	private int size;
	
	public MyArrayList() {
		capacity = 10;
		size = 0;
		data = new int[capacity];
	}
	
	public void add(int element) {
		if (!isFull()) {
			data[size++] = element;
		} else {
			growth();
			data[size++] = element;
		}
	}
	
	private boolean isFull() { return size == capacity; }
	
	private void growth() {
		capacity = capacity + (capacity >> 1);  // capacity * 1.5 and ensure int value no overflow
		data = Arrays.copyOf(data, capacity);  //注意，一定要将copyOf之后的结果赋给 data array，要不然 data array就没有变化
	}
	
	public int get(int index) {
		rangeCheck(index);
		
		return data[index];
	}
	
	public void set(int index, int element) {
		rangeCheck(index);
		
		data[index] = element;
	}
	
	/**
	 * When removing, return the old value
	 * @param index
	 * @return
	 */
	public int remove(int index) {
		rangeCheck(index);
		
		int oldValue = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[--size] = Integer.MIN_VALUE; // Use MIN_VALUE to represent the un-reached element
		return oldValue;
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
	}
	
	public int getSize() { return size; }
	
	public void display() {
		System.out.print("The current array list is: ");
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}