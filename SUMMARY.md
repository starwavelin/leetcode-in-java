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

### Binary Search

#### Transformation between 2D and 1D Arrays
Disregarding whether the combined one-dimensional array is strictly increasing, the following formula can be used for any 2D, 1D array transformations.  
*m*: the number of rows in 2D arrray;  
*n*: the number of columns in 2D array;  
*m x n*: the full length of the combined 1D array;  
*index*: a number's index in the 1D array, starting from 0;  
*row*: the row index of a number in 2D array, starting from 0;  
*col*: the col index of a number in 2D array, starting from 0.  
##### 2D to 1D transformation
```
index = row * n + col % n  
```  
(can also be written as ```index = row * n + col```)
##### 1D to 2D transformation
```
row = index / n
```  
```
col = index % n
```

#### Binary Search Template
The following template with its transformations can be used to find the first, last or any position of a target number in a *Sorted* array.  
The following template is for finding the first position the target number occurs in an array, with other options written in the code comments.  
```java
public int search(int[] nums, int target) {
	if (nums == null || nums.length == 0) {
		return -1; /* -1 means cannot find target */
	}
	int start = 0, end = nums.length - 1, mid;
	while (start + 1 < end) {
		mid = start + (end - start) / 2; /* avoid overflow */
		if (nums[mid] == target) {
			end = mid; /* You can use start = mid for last position, and return mid for any position */
		} else if (nums[mid] < target) {
			start = mid;
		} else {
			end = mid;
		}
	}

	if (nums[start] == target) {
		return start;
	} else if (nums[end] == target) {
		return end;
	}	/* For last position, you want to flip the checking order to check nums[end] first. For any position, it doesn't matter */

	return -1;
}
```

### Binary Tree


## 排序算法

## 图

## 回溯法
