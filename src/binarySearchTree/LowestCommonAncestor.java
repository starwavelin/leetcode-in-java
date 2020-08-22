package binarySearchTree;

import utility.TreeNode;
/***************************************************************************
* Problem No. : 235
* Problem Name: Lowest Common Ancestor of a Binary Search Tree
* Problem URL : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
* Date        : Nov 9 2017
* Author      :	@codingbro
* Notes       : 
* 	Scenario: 
* 	
* 	Assumption:
* 		
	Example:
* 	Input: 
* 	Output: 
* 	Data Structure and Alg:
* 		See code comments
* Complexity  : 
* 	Time Complexity: O(h) cuz traverse the height of the tree minus 1
* 	Space Complexity: O(1) 
* 
* meta        : tag-binary-search-tree
***************************************************************************/
public class LowestCommonAncestor {
	/**
	 * Solution 1:
	 * 	Recursive solution: if current root less than the min of the two given nodes, move root to right;
	 * if current root larger than the max of the two given nodes, move root to left;
	 * otherwise current root is the solution.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q); //要在子问题就有所return
        } else if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
	
}
