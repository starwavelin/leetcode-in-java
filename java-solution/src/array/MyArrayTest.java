package array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyArrayTest {

	@Test
	public void testInsertions() {
		MyArray arr = new MyArray(5);
		arr.insert(2);
		arr.insert(9);
		arr.insert(1);
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
		assertEquals("arr's 2nd element should be 9", 9, arr.getIndex(1));
		assertEquals("arr's 3rd element should be 1", 1, arr.getIndex(2));
	}
	
	@Test
	public void testDelete1stOccurrence() {
		MyArray arr = new MyArray(5);
		arr.insert(2);
		arr.insert(9);
		arr.insert(9);
		arr.insert(7);
		arr.delete1stOccurrence(9);
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
		assertEquals("arr's 2nd element should be 9", 9, arr.getIndex(1));
		assertEquals("arr's 3rd element should be 7", 7, arr.getIndex(2));
	}
	
	// [8, 8, 2, 7]
	@Test
	public void testDeleteAllTargetAtBeginning() {
		MyArray arr = new MyArray(5);
		arr.insert(8);
		arr.insert(8);
		arr.insert(2);
		arr.insert(7);
		arr.deleteAll(8);
		assertEquals("arr's size becomes 2", 2, arr.getSize());
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
		assertEquals("arr's 2nd element should be 7", 7, arr.getIndex(1));
	}
	
	// [8, 2, 8, 8]
	@Test
	public void testDeleteAllTargetAtBeginningAndAtEnd() {
		MyArray arr = new MyArray(5);
		arr.insert(8);
		arr.insert(2);
		arr.insert(8);
		arr.insert(8);
		arr.deleteAll(8);
		assertEquals("arr's size becomes 1", 1, arr.getSize());
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
	}
	
	// [2, 8, 7, 8, 8]
	@Test
	public void testDeleteAllTargetAtMiddleAndConsecutiveAtEnd() {
		MyArray arr = new MyArray(10);
		arr.insert(2);
		arr.insert(8);
		arr.insert(7);
		arr.insert(8);
		arr.insert(8);
		arr.deleteAll(8);
		assertEquals("arr's size becomes 2", 2, arr.getSize());
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
		assertEquals("arr's 2nd element should be 7", 7, arr.getIndex(1));
	}
	
	// [2, 8, 8, 8, 16, 8]
	@Test
	public void testDeleteAllTargetConsecutiveAtMiddleAndAtEnd() {
		MyArray arr = new MyArray(10);
		arr.insert(2);
		arr.insert(8);
		arr.insert(8);
		arr.insert(8);
		arr.insert(16);
		arr.insert(8);
		arr.deleteAll(8);
		assertEquals("arr's size becomes 2", 2, arr.getSize());
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
		assertEquals("arr's 2nd element should be 16", 16, arr.getIndex(1));
	}
	
	// [2, 8, 5, 8, 27, 8]
	@Test
	public void testDelete1OccurrenceAndDeleteAll() {
		MyArray arr = new MyArray(10);
		arr.insert(2);
		arr.insert(8);
		arr.insert(5);
		arr.insert(8);
		arr.insert(27);
		arr.insert(8);
		arr.delete1stOccurrence(5);
		arr.deleteAll(8);
		assertEquals("arr's size becomes 2", 2, arr.getSize());
		assertEquals("arr's 1st element should be 2", 2, arr.getIndex(0));
		assertEquals("arr's 2nd element should be 27", 27, arr.getIndex(1));
	}
}
