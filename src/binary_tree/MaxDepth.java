package binary_tree;

import utility.TreeNode;

public class MaxDepth {
	
	public static class Solution {
		public int maxDepth(TreeNode root) {
	        if (root == null)
	            return 0;
	        if (root.left == null && root.right == null)
	            return 1;
	        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	    }
	}

}
