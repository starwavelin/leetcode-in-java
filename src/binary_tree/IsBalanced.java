package binary_tree;

import utility.TreeNode;

public class IsBalanced {
	
	public static class Solution {
		public boolean isBalanced(TreeNode root) {
	        if (root == null) 
	            return true;
	        boolean isLeftBalanced = isBalanced(root.left);
	        boolean isRightBalanced = isBalanced(root.right);
	        return isLeftBalanced && isRightBalanced && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
	    }
		
		private int maxDepth(TreeNode root) {
	        if (root == null)
	            return 0;
	        if (root.left == null && root.right == null)
	            return 1;
	        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	    }
	}
	
}
