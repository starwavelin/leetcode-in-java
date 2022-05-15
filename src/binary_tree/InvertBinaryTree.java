package binary_tree;

import utility.TreeNode;

/* Note: all the classes in binary_tree package may use TreeNode class or TreeNodeP class defined in the
 * utility package, depending on if the given TreeNode model has a parent reference or not */

/***************************************************************************
* Problem No. : 226
* Problem Name: Invert Binary Tree
* Problem URL : https://leetcode.com/problems/invert-binary-tree/description/
* Date        : Oct 20 2017
* Author	  :	@codingbro
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
* meta        : tag-binary-tree, tag-divide-and-conquer
***************************************************************************/
public class InvertBinaryTree {

	/**
	 * Solution 1:
	 * Recursive top-down approach
	 * 
	 * For each root, use a tmp variable to help swap its left subtree and right subtree, until reaching 
	 * the leaves and finishing to process them.
	 * 
	 * Time Complexity: O(n) cuz traverse all the nodes
	 * Space Complexity: O(1) cuz just open a new var tmp
	 * 
	 * Note: 这个解法基本不利用返回值，你看
	 *  invertTree(root.left);
		invertTree(root.right);
		是不赋值给某个变量的， 但最终结果要求返回overall的根，所以在 invertTree() 函数的结尾，return root
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
	
	/**
	 * Solution 2:
	 * D&C, Bottom-Up approach
	 * 
	 * We ASSUME the current root's left is processed by assigning the root's right to it
	 * and also assume the current's root's right is processed by assigning the root's left to it.
	 * And the actual process is done in the leaf level and return back
	 * 
	 * Time Complexity: O(n) -- traverse all the nodes
	 * Space complexity: O(1) -- Use a tmp reference to help the invert process.
	 */
	public static TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = invertTree2(root.right);
		root.right = invertTree2(tmp);
		return root;
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
		
		//If applying invertTree method again (no matter version 1 or 2), the tree shall be set back
		invertTree2(root);
		System.out.println(String.format("Current tree is: %d, %d, %d ,%d", root.val, root.left.val, root.right.val, root.left.right.val));
	}
}
