package data_structure;

public class MyArrayListTest {
	
	public static void main(String[] args) {
		MyArrayList myal = new MyArrayList();
		for (int i = 1; i <= 10; i++) {
			myal.add(i);
		}
		myal.display();
		
		myal.add(186);
		myal.display(); // should resize and see the element 186 being added to the end
		
		System.out.println(myal.get(3)); // should return 4
		System.out.println(myal.remove(3)); // should return 4;
		myal.display(); // should see the number 4 is gone from the previous array list
		
		myal.remove(0);
		myal.display(); // should see the number 1 is gone from the previous array list
		System.out.println("Now the number of elements in the array list is: " + myal.getSize()); // should be 9
	}
	
}
