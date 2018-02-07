package binaryTree;

import utility.TreeNode;

public class LowestCommonAncestorBT {

	/**
	 * Divide and Conquer
	 * 3 cases:
	 * 1. C is the common ancestor of p, q
	 * 			 C
	 * 			/  \
	 *		   p    q
	 *
	 * 2. common ancestor aligns middle to left
	 * 
	 * 		  p
	 * 		/
	 *     q
	 *  
	 * 3. common ancestor aligns middle to right
	 * 			p
	 * 			  \
	 * 				q	 
	 * 
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
        		return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
        		return root;
        } else if (left != null) {
        		return left;
        } 
        return right;
    }
	
}
