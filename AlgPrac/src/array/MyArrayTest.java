package array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyArrayTest {

	@Test
	public void test() {
		MyArray arr = new MyArray(10);
		arr.insert(2);
		arr.insert(9);
		arr.insert(1);
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
		assertEquals("arr's 2nd element should be 9", 9, arr.getIndex(1));
		assertEquals("arr's 3rd element should be 1", 1, arr.getIndex(2));
	}

}
