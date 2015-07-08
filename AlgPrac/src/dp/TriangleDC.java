package dp;

/**
 * http://www.lintcode.com/en/problem/triangle/
 * If the interviewer allows any data structure, you can
 *  make it a binary tree style structure, and use 
 *  D&C to solve it.
 */

public class TriangleDC {
	
	public int minPathSum(Node root) {
	    if (root == null) {
	        return 0;
	    }

	    if (root.left == null || root.right == null) {
	        return root.val;
	    }
	    
	    int left = minPathSum(root.left);
	    int right = minPathSum(root.right);
	    int sum = root.val + Math.min(left, right);
	    return sum;
	}  
	
}

class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int val) {
		this.val = val;
		left = right = null;
	}
}