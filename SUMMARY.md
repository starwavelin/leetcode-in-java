## 线性解空间

### Two Pointer solution

#### Merging Two Sorted Arrays Template
Setting a new array of size m+n  
```java
public int[] merge(int[] A, int[] B) {
	int[] res = new int[A.length + B.length];
	int i = 0, j = 0, k = 0;
	while (i < A.length && j < B.length) {
		res[k++] = (A[i] < B[j]) ? A[i++] : B[j++];
	}
	while (i < A.length) {
		res[k++] = A[i++];
	}
	while (j < B.length) {
		res[k++] = B[j++];
	}
	return res;
}
```
三while loop模板。  
Think: how does the template listed above relate to the merge function defined in merge sort?

#### Reversing Word/Array Template
reverse function using char[] as example  
```java
public void reverse(char[] s, int start, int end) {
	while (start < end) {
		char tmp = s[start];
		s[start++] = s[end];
		s[end--] = tmp;
	}
}
```

### Stack Type

#### Best Practice of Using Stack in Java
In the past I always used ```Stack``` class from Java API to represent a stack. However, it is not recommended in the industry because ```Stack``` is thread-safe, which will cause overhead. Instead, industry usually uses [```ArrayDeque```](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html) to implement a stack.  
Initialization: Old Way  
```java
Stack<T> s = new Stack<>();
```
Initialization: New Way  
```java
Deque<T> stack = new ArrayDeque<>();
```
##### Compare of the methods a stack can have  
You should use the methods under ArrayDeque to mimick a stack

| Using Stack| Using ArrayDeque|
| -----------|:---------------:|
| push(E e)  | offerLast(E e)  |
| pop()      | pollLast()      |
| empty()    | isEmpty()       |
| peek()     | peekLast()      |

*I personally like to use ```xxxLast()``` methods to mimick push, pop, peek, but you can also use the same set of ```xxxFirst()``` to mimick these actions. But, do please be consistent.*  
*Added on 2018-04-16:* Deque is an interface which extends Queue, and Deques can also be used as LIFO (Last-In-First-Out) stacks. In the new way of initialization, I can also use ```stack.push(e)``` which is equivalent to ```stack.addFirst(e)```, per [Deque API](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)

### Hash Type

### LinkedList Type

#### Finding the Middle Node Templates
For a linked list with odd number of nodes, the middle node is the middle one; for a linked list with even nodes, we define the middle node to be the first one of the central two nodes.    
Method: Fast slow pointers  
```java
public Node findMiddle(Node head) {
	if (head == null || head.next == null) {
		return head;
	}
	Node fast = head, slow = head;
	while (fast.next != null && fast.next.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}
	return slow;
}
```

#### Reverse Linked List Templates
##### Iterative Way
```java
public Node reverse(Node head) {
	Node prev = null, next = null;
	while (head != null) {
		next = head.next;
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
}
```

### String Input Type

#### Longest Substring Template
```java
public int lengthOfLongestSubstring(String s) { /* could have another parameter for number of distinct chars */
	// 1. Defensive Check over s

	// 2. Setup an array map of 256
		// Think (1): initialize the cells with 0 or -1?
		// (2): what will this map store, key - char, value - occurrence of a char, or the last index of the occurrence of this char?

	// 3. Initialize left pointer, maxLen, (and count - the number of distinct chars)
	for (int r = 0; r < s.length(); r++) {
		/* In what circumstances you need to move l? */


		maxLen = max(maxLen, r - l + 1);
	}
	return maxLen;
}
```

### Array Input Type

## 二叉解空间

## 排序算法

## 图

## 回溯法
