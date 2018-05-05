## Table of Contents
- [Linear Solution Space](#linear-solution-space)
  - [Two Pointer Method](#two-pointer-method)
    - [Merging Two Sorted Arrays Template](#merging-two-sorted-arrays-template)
    - [Reversing Word/Array Template](#reversing-wordarray-template)
  - [Stack Type](#stack-type)
  - [Hash Type](#hash-type)
  - [LinkedList Type](#linkedlist-type)
    - [Finding the Middle Node Templates](#finding-the-middle-node-templates)
    - [Reverse Linked List Templates](#reverse-linked-list-templates)
      - [Iterative Way](#iterative-way)
  - [String Input Type](#string-input-type)
    - [Longest Substring Template](#longest-substring-template)
  - [Array Input Type  ](#array-input-type-)
- [Binary Solution Space](#binary-solution-space)
  - [Binary Search](#binary-search)
    - [Transformation between 2D and 1D Arrays](#transformation-between-2d-and-1d-arrays)
      - [2D to 1D transformation](#2d-to-1d-transformation)
      - [1D to 2D transformation](#1d-to-2d-transformation)
    - [Binary Search Template](#binary-search-template)
  - [Binary Tree](#binary-tree)
    - [BFS](#bfs)
    - [DFS](#dfs)
    - [Divide and Conquer](#divide-and-conquer)
    - [Binary Tree Max Path Sum From Root](#binary-tree-max-path-sum-from-root)
- [Sorting Algorithms](#sorting-algorithms)
  - [Comparison Sorting](#comparison-sorting)
    - [Bubble Sort](#bubble-sort)
    - [Selection Sort](#selection-sort)
    - [Insertion Sort](#insertion-sort)
    - [Merge Array Template](#merge-array-template)
    - [Merge Sort](#merge-sort)
    - [Partition Array Templates](#partition-array-templates)
    - [Quick Sort](#quick-sort)
  - [Non-Comparison Sorting](#non-comparison-sorting)
- [Graph](#graph)
    - [DFS Template](#dfs-template)
    - [BFS Template](#bfs-template)
    - [Matrix Movement Template](#matrix-movement-template)
- [Backtracking](#backtracking)
- [Dynamic Programming](#dynamic-programming)
- [Other Type Trees](#other-type-trees)
- [Data Structure Design](#data-structure-design)
- [Bit Operation](#bit-operation)
  - [Concepts](#concepts)
    - [Division by 2 or 2's Exponents](#division-by-2-or-2s-exponents)
    - [Biwise AND to help Mod (%), the operand after ```%``` must be ```2^n```](#biwise-and-to-help-mod-the-operand-after-must-be-2n)
    - [How to avoid integer overflow?](#how-to-avoid-integer-overflow)
    - [>> vs >>>](#-vs-)
    - [2's Complement | 补码](#2s-complement-)
    - [-5 % 3 = ? in Java and Python](#-5-3-in-java-and-python)
- [Math](#math)

# Linear Solution Space

## Two Pointer Method

### Merging Two Sorted Arrays Template
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

### Reversing Word/Array Template
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

## Stack Type

## Hash Type

## LinkedList Type

### Finding the Middle Node Templates
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

### Reverse Linked List Templates
#### Iterative Way
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

## String Input Type

### Longest Substring Template
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

## Array Input Type  

[[↑] Back to top](#table-of-contents)

# Binary Solution Space

## Binary Search

### Transformation between 2D and 1D Arrays
Disregarding whether the combined one-dimensional array is strictly increasing, the following formula can be used for any 2D, 1D array transformations.  
*m*: the number of rows in 2D arrray;  
*n*: the number of columns in 2D array;  
*m x n*: the full length of the combined 1D array;  
*index*: a number's index in the 1D array, starting from 0;  
*row*: the row index of a number in 2D array, starting from 0;  
*col*: the col index of a number in 2D array, starting from 0.  
#### 2D to 1D transformation
```
index = row * n + col % n  
```  
(can also be written as ```index = row * n + col```)
#### 1D to 2D transformation
```
row = index / n
```  
```
col = index % n
```

### Binary Search Template
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

## Binary Tree

### BFS
I directly use the binary tree level order traversal as a template
```java
public List<List<Integer>> levelOrder(Node root) {
	List<List<Integer>> res = new ArrayList<>();

	if (root == null) {
		return res;
	}

	Queue<Node> queue = new LinkedList<>();
	queue.offer(root);

	while (!queue.isEmpty()) {
		List<Integer> level = new ArrayList<>();
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			Node t = queue.poll();
			if (t.left != null) {
				queue.offer(t.left);
			}
			if (t.right != null) {
				queue.offer(t.right);
			}
			level.add(t.val);
		}
		res.add(level);
	}
	return res;
}
```
If we don't need to consider levels and just want to purely bfs traversal of a binary tree. ie. we wanna serialize a binary tree by BFS traversal:
```
/*
Binary Tree:                                                         
    1                                                                        
    / \
  2   3
      / \
    4   5

Queue:

String:
1,2,3,#,#,4,5,#,#,#,#,
*/
```
Then the BFS template can be as simple as:  
```java
public String serialize(TreeNode root) {
	StringBuilder sb = new StringBuilder();

	if (root == null) {
		return null;
	}

	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);

	while (!queue.isEmpty()) {
		TreeNode t = queue.poll();
		if (t == null) {
			sb.append("#,");
		} else {
			sb.append(t.val + ",");
			queue.offer(t.left);
			queue.offer(t.right);
		}
	}

	return sb.substring(0, sb.length() - 1);
}
```

### DFS
The binary tree's DFS template is basically about the 3 type of traverse: preorder, inorder and postorder.  
The following code use pre-order traversal as an example:  
```java
public void traverse(Node root) {
	if (root == null) {
		return;
	}

	//Do something with root

	traverse(root.left);
	traverse(root.right);
}
```

### Divide and Conquer
```java
public ReturnType f(Node root, List<E> res) {
	//Base case: may be like below
	if (root == null) {
		return null;
	}

	//Divide
	ReturnType left = f(root.left);
	ReturnType right = f(root.right);

	//Conquer
	/* Combine the left and right subtree solutions into one */
	/* res will be updated here */
}
```
One example is [Binary Tree Max Path Sum From Root](#binary-tree-max-path-sum-from-root)  
**Further**  
Divide and Conquer methodology is like MapReduce, where map is "divide" and reduce is "conquer".

### Binary Tree Max Path Sum From Root
**Problem**  
Given a binary tree, find the maximum path sum from its root. The path may end at any node, and contain at least one node in it.  
Keep in mind, for this problem, a node may have negative, 0 or positive integer value.

**Analize**  
This is the prerequisite questions for LeetCode 124 [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/) in which the path is defined as any node to any node following the parent-child connection.  
Use Divide and Conquer to solve.  
Code run: bottom up    

**Code**
```java
public int maxPathSum(TreeNode root) {
  if (root == null) {
    return 0;
  }
  int left = maxPathSum(root.left);
  int right = maxPathSum(root.right);
  return root.val + Math.max(Math.max(left, right), 0);
}
```

**Complexity**  
Time Complexity: O(n) cuz we traversed every node  
Space Complexity: Recursion stack -- O(logn) if balanced tree and O(n) if linear shape tree.  

[[↑] Back to top](#table-of-contents)

# Sorting Algorithms

## Comparison Sorting

### Bubble Sort
**What is Bubble Sort?** You can review from
[here](http://blog.csdn.net/han_xiaoyang/article/details/12163251)
and look for *五、冒泡排序*  
**口诀** 两两比较，大数先排好到最后，小数逐步浮向前。  
**Code**
```java
public void sort(int[] nums) {
	for (int i = nums.length - 1; i > 0; i--) {
		for (int j = 1; j <= i; j++) { /* 大数逐渐移动到后面，所以是从nums.length-1 -- 0 逐步有序化*/
			if (nums[j] < nums[j - 1]) {
				swap(nums, j, j - 1);
			}
		}
	}
}
private void swap(int[] nums, int i, int j) {
	int t = nums[i];
	nums[i] = nums[j];
	nums[j] = t;
}
```
**Time Complexity** O(n^2)

### Selection Sort
**What is Selection Sort?** You can review from [here](http://blog.csdn.net/han_xiaoyang/article/details/12163251)
and look for *四、选择排序*
**口诀** 找最小数，与左互换。  
**Code**
```java
public void sort(int[] nums) {
	for (int i = 0; i < nums.length - 1; i++) {
		int minIndex = i;
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[j] < nums[minIndex]) {
				minIndex = j;
			}
		}
		if (minIndex != i) {
			swap(nums, i, minIndex);
		}
	}
}
```
**Notes**  
Time Complexity:  
Worst: O(n^2)  Average: O(n^2)  Best: O(n^2)  
三者相同的原因：因为无论何种情况每次取min都要扫描余下的数，
扫描```(n-1) + (n-2)... + 1 = n(n-1)/2``` 次

### Insertion Sort
**What is Insertion Sort?**  
The first couple (worst case scenario only the first one) elements are already
sorted, and we just find the next unsorted element, and find the right position
for this element to be added in, and shift the elements that come after this
element being inserted.  
You can review from
[here](http://blog.csdn.net/han_xiaoyang/article/details/12163251)
and look for *一、插入排序*  
**口诀** 局部有序，挪移插入。  
**Code**
```java
public void sort(int[] nums) {
	for (int i = 1; i < nums.length; i++) { /* starting from i=1 cuz i=0 is definitely sorted */
		int j = i;
		int cur = nums[j];
		while (j > 0 && cur < nums[j-1]) { //挪移
			nums[j] = nums[j-1];
			j--;
		}
		nums[j] = cur; //插入
	}
}
```
注意：  
1. 双指针法：移动着的j来实现挪移和插入  
2. 要先把```nums[j]```用变量存起来，否则在挪移中，```nums[j]```被更新而没有事先存，
就丧失了要插入的小的数

**Notes**  
Time Complexity:  
Worst: O(n^2)   
Best: O(n) comparions and O(1) swap.  
Best case O(n) will occur if the given numbers are already sorted in ascending
order, then we only loop the nums and no insertions involved; or there is just
one element needs to be inserted into front.    
That said, Insertion Sort will be efficient if the given numbers are pretty
much ordered.  

### Merge Array Template
This merge array template would be helpful for mergeSort.  
You may also review LeetCode [88. Merge Sorted Array](https://github.com/starwavelin/AlgorithmPractice/blob/master/AlgPrac/src/array/MergeSortedArray.java#L122) as a reference.  

```java
public void merge(int[] nums1, int m, int[] nums2, int n) { /* m - length of nums1; n - length of nums2 */
	int[] tmp = new int[m + n];
	int i = 0, j = 0, k = 0;

	/* 代码块 */
	while (i < m && j < n) {
		tmp[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
	}
	while (i < m) {
		tmp[k++] = nums1[i++];
	}
	while (j < n) {
		tmp[k++] = nums2[j++];
	}

	for (i = 0; i < k; i++) {
        nums1[i] = tmp[i];
    }
}
```

The ```merge``` part of mergeSort is to combine the arrays of elements from ```start``` to ```mid``` and from ```mid + 1``` to ```end```  
Surely ```start```, ```mid``` and ```end``` are given from the mergeSort function, which means their values are valid.  
And you can see we will have ```i <= m_index``` and ```j <= n_index``` then.  

```java
public void merge(int[] nums, int start, int mid, int end) {
	int[] tmp = new int[nums.length];
	int i = start, j = mid + 1, k = start;

	while (i <= mid && j <= end) {
		tmp[k++] = (nums[i] < nums[j]) ? nums[i++] : nums[j++];
	}
	while (i <= mid) {
		tmp[k++] = nums[i++];
	}
	while (j <= end) {
		tmp[k++] = nums[j++];
	}

	for (i = start; i < k; i++) { /* when copy to original array nums, i should start from `start` */
		nums[i] = tmp[i];
	}
}
```

### Merge Sort
```java
public void mergeSort(int[] nums) {
	sort(nums, 0, nums.length - 1);
}

private void sort(int[] nums, int start, int end) {
	if (end <= start) {	// be careful of this exit condition!!!
		return;
	}
	int mid = start + (end - start) / 2;
	sort(nums, start, mid);
	sort(nums, mid + 1, end);
	merge(nums, start, mid, end);
}

private void merge(int[] nums, int start, int mid, int end) {
	int[] tmp = new int[nums.length];
	int i = start, j = mid + 1, k = start;

	while (i <= mid && j <= end) {
		tmp[k++] = (nums[i] < nums[j]) ? nums[i++] : nums[j++];
			/* nums[i] < nums[j] is an instable version; <= gives a stable version */
	}
	while (i <= mid) {
		tmp[k++] = nums[i++];
	}
	while (j <= end) {
		tmp[k++] = nums[j++];
	}
	for (i = start; i < k; i++) {
		nums[i] = tmp[i];
	}
}
```

### Partition Array Templates

### Quick Sort


## Non-Comparison Sorting

[[↑] Back to top](#table-of-contents)

# Graph

### DFS Template
```java
dfs (node) {
	// process the current node, mark it as visited
	for () {	// traverse all the nodes that are the neighbors of the current node
		标记更改;
		dfs (next sub-circumstance);
		恢复更改;
	}
	return … ;
}
```

### BFS Template
```java
Queue<Type> q = new LinkedList<>();
q.offer(初始状态);
while (!q.isEmpty()) {
	Type t = q.peek(); // OR Type t = q.poll();
	for (    )  {	// 遍历t的各个next状态  next
		//一些操作
		if (next is legal) {
			q.offer(next);
			计数或者维护 etc.
		}
		//一些操作
	}
}
```

### Matrix Movement Template
Assume you have a matrix of numbers representing the graph, and from each cell, you can either move up, down, left or right, in total 4 directions.  
ie. [200. Nunber of Islands](https://leetcode.com/problems/number-of-islands/description/)  
Then, assume x represents the row, and y represents the column. So we have *x-1* represents move up 1 cell and *y+1* represents move right 1 cell. Then,
```java
/* row, col are the original coordinates passed in from the parameters */
int[] dx = new int[]{-1, 1, 0, 0};
int[] dy = new int[]{0, 0, -1, 1};
for (int i = 0; i < 4; i++) { //cuz 4 directions
	int rowNum = row + dx[i];
	int colNum = col + dy[i];
	//dfs(grid, rowNum, colNum, m, n); //m - num of rows; n - num of columns.
}
```

# Backtracking

# Dynamic Programming

# Other Type Trees

# Data Structure Design

# Bit Operation

## Concepts

### Division by 2 or 2's Exponents
Divison by 2 or 2's exponent can be expressed in right shift ">>".  
ie. 6 / 2  === 6 >> 1  
cuz (in binary) 6 is 110 and 110 right shift one bit becomes 11 and 11 in decimal is 3.  
ie. 16 / 4 === 16 >> 2  which is 10000 >> 2 = 100  
Note: when using bit operation to do calculation, writing comments will be good cuz bit operation is not easily readable.  
```
int i = 16 >> 2 // divide by 4
```  

### Biwise AND to help Mod (%), the operand after ```%``` must be ```2^n```
In circuar array, when ```array[0]``` is filled and ```array[len-1]``` is empty and we append to head:  
```
(head - 1 + len) % len === (head - 1) & (len - 1)
```  
Using & is more efficient cuz % is still some division operations, and ```+ len``` still has a risk of overflow.  
Similarly, ```(tail + 1) % len === (tail + 1) & (len - 1)```  
And, ```&``` can only help when the operand after ```%``` is ```2^n```  
```
X mod 2^n = X & (2^n - 1)
```  

### How to avoid integer overflow?
Try not to let the intermediate value exceed the result.  
ie. ```int newCapacity = oldCapacity + oldCapacity >> 1```  in which ```oldCapacity >> 1``` is always less than ```newCapacity```

### >> vs >>>
'>>' means using the current leftmost digit to fill in the leftmost digit after right shift; '>>>' means using 0 to fill in the leftmost digit after a right shift.

### 2's Complement | 补码
|      | Unsigned | 1's Complement|2's Complememnt|
| -----| ---------| --------------|---------------|
| 000  | 0        | 0             | 0             |
| 001  | 1        | 1             | 1             |
| 010  | 2        | 2             | 2             |
| 011  | 3        | 3             | 3             |
| 100  | 4        | -0            | -4            |
| 101  | 5        | -1            | -3            |
| 110  | 6        | -2            | -2            |
| 111  | 7        | -3            | -1            |

### -5 % 3 = ? in Java and Python
In Java, we got -2, Remainder.  
In Python, we got 1, Modular.  
Modular: -5 / 3 = roundFloor(-1.66) = -2  
  -2 * 3 = -6  
  -5 - (-6) = 1  
If we want it to be 1 in Java, we need ```Math.floorMod(-5, 3)```

[[↑] Back to top](#table-of-contents)

# Math
