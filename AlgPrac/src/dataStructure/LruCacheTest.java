package dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LruCacheTest {
	
	
	/*
	 * ["LRUCache","put","put","get","put","get"]
		[[2],[1,1],[2,2],[1],[3,3],[2]]
	 * */

	@Test
	void testPuttingTwoNodesAndGetOneByKey() {
		LruCache cache = new LruCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals("Should get key 1's value which is also 1", 1, cache.get(1));
	}
	
	@Test
	void testFullExample() {
		LruCache cache = new LruCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals("Should get key 1's value which is also 1", 1, cache.get(1));
		cache.put(3, 3);
		assertEquals("When trying to get key 2, should not found cuz <2, 2> is evicted", Integer.MIN_VALUE, cache.get(2));
		assertEquals("Before key 3 is updated, key 3's value is 3", 3, cache.get(3));
		cache.put(3, 303);
		assertEquals("Before key 3 is updated, key 3's value is 303", 303, cache.get(3));
	}

}
