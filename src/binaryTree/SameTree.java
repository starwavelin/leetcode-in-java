package binaryTree;

import utility.TreeNode;

public class SameTree {
	
	/**
	 * In the Solution class below, inside inorder(), 
	 * if I just wrote base case as 
	 * 	```
	 * 	if (root == null)
	 * 		return;
	 * 	```
	 * I cannot handle this case:
	 * 
	 * 	    1         1
	 * 	   /	        / \
	 * 	  1	       null 1
	 * 
	 * Directly returning will give me "11" and "11" so the two Strings will be equal.
	 * 
	 * How to solve this?
	 * when null, instead of append nothing, I still append a char like "#" then return;
	 * And I figure out using inorder will make the result strings the same, so I use preorder to avoid this.
	 * 
	 */
	public static class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
	        if (p == null && q == null)
	            return true;
	        StringBuilder sb1 = new StringBuilder();
	        StringBuilder sb2 = new StringBuilder();
	        preorder(p, sb1);
	        preorder(q, sb2);
	        return sb1.toString().equals(sb2.toString());
	    }
	    
	    private void preorder(TreeNode root, StringBuilder sb) {
	        if (root == null) {
	        	    sb.append("#");
	            return;
	        }
	        sb.append(root.val);
	        preorder(root.left, sb);
	        preorder(root.right, sb);
	    }
	}
	
}
