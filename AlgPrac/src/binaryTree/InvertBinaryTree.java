package binaryTree;

import utility.TreeNode;

/* Note: all the classes in binaryTree package may use TreeNode class or TreeNodeP class defined in the 
 * utility package, depending on if the given TreeNode model has a parent reference or not */

/***************************************************************************
* Problem No. : 226
* Problem Name: Invert Binary Tree
* Problem URL : https://leetcode.com/problems/invert-binary-tree/description/
* Date        : Oct 20 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Invert a binary tree based on the vertical symmetry. 
* 		In another word, besides the overall root, other nodes in the left and right subtrees will be inverted.
* 	Assumption:
* 		1. The return type would be TreeNode representing the overall root of the inverted tree. 
	Example:
* 	Input/Output:
* 		See examples provided in the Problem URL 
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-binary-tree
***************************************************************************/
public class InvertBinaryTree {

	/**
	 * Solution 1:
	 * Recursion top-down approach
	 * For each root, use a tmp variable to help swap its left subtree and right subtree, until reach 
	 * leaves and finish processing them.
	 * 
	 * Time Complexity: O(n) cuz traverse all the nodes
	 * Space Complexity: O(1) cuz just open a new var tmp
	 */
	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tmp = root.left; 
		root.left = root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;	
			/* when finishing processing invertTree(root.left) and invertTree(root.right)
			 return the relative root from the method. 
			 when `return root` is hit, that means the current root is PROCESSED */	
	}
	
	
	public static TreeNode invertTree2(TreeNode root) {
		return null;
	}
	
	
	public static void main(String[] args) {
		/*
		 * A given tree looks like
		 * 			9
		 * 		7		2
		 * 		   3	
		 * 
		 * After inversion
		 * 			9
		 * 		2		7
		 * 			  3 
		 * */
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(3);
		System.out.println(String.format("Current tree is: %d, %d, %d ,%d", root.val, root.left.val, root.right.val, root.left.right.val));
		invertTree(root);
		System.out.println(String.format("Current tree is: %d, %d, %d ,%d", root.val, root.left.val, root.right.val, root.right.left.val));
		
		
		
		
	}
}
