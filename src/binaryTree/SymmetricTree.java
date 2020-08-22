package binaryTree;

import utility.TreeNode;

/***************************************************************************
* Problem No. : 101
* Problem Name: Symmetric Tree
* Problem URL : https://leetcode.com/problems/symmetric-tree/description/
* Date        : Oct 24 2017
* Author	  :	@codingbro
* Notes       : 
* 	Scenario: 
* 		Determine if a tree is symmetric; and this "symmetric" means being symmetric against the vertical axis of symmetry
* 	Assumption:
* 		
	Example:
* 	Input/Output:
* 		See examples provided in the Problem URL 
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-binary-tree, tag-divide-and-conquer
***************************************************************************/
public class SymmetricTree {
	
	/**
	 * Solution 1;
	 * 	Recursive way, top down approach
	 * For the overall one root
	 * 	base case: if root is null return true;
	 *  recursive: determine if the root's leftRoot and rightRoot are symmetric
	 * For the case of comparing leftRoot and rightRoot,
	 * 	base case: if both leftRoot and rightRoot are null, return true
	 * 	base case 2: if either of leftRoot or rightRoot but not both is null, or they are not null but their value are not equal, return false
	 *  recursive: determine if (leftRoot.left, rightRoot.right) and (leftRoot.right, rightRoot.left) are both true
	 * 
	 * Time Complexity: O(n) traverse all the nodes;
	 * Space Complexity: Recursion stack  O(h)  h is the height of the tree. 
	 */
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	private static boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
		if (leftRoot == null && rightRoot == null) {
			return true;
		}
		if ((leftRoot == null && rightRoot != null) || (rightRoot == null && leftRoot != null)
				|| (leftRoot.val != rightRoot.val)) {
			return false;
		}
		return isSymmetric(leftRoot.left, rightRoot.right) && isSymmetric(leftRoot.right, rightRoot.left);
	}
	
	public static void main(String[] args) {
		/*
		 * A given tree looks like
		 * 			1
		 * 		2		2
		 * 	  5	  3   5	  3		NO!
		 * 
		 * A given tree looks like
		  			1
		 * 		2		2
		 * 	  5	  3   3	  5		YES!
		 * */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(3);
		System.out.println("Is this tree symmetric? " + isSymmetric(root)); // should be false
		
		//change a little of the previous tree		
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		System.out.println("Is this tree symmetric? " + isSymmetric(root)); // should be true
	}
}
