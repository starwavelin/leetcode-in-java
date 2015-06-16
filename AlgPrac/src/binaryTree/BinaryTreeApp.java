package binaryTree;

import java.util.Scanner;

public class BinaryTreeApp {
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Binary Tree Test ***");
		
//		int[] arr = {1, 2, 3};
//		int[] arr ={8, 5, 9, 7};
		int[] arr = {6, 4, 8, 1, 7, 3, 9, 2, 5};
		BinaryTree tree = new BinaryTree();
		for (int i = 0; i < arr.length; i++) {
			tree.insert(tree.root, arr[i]);
		}
		
		// Test insert, preorder, inorder, postorder
		System.out.print("The preorder traversal of the given tree is: ");
		tree.preorderTraverseNoRec(tree.root);
		System.out.println();		
		System.out.print("The inorder traversal of the given tree is: ");
		tree.inorderTraverseNoRec(tree.root);
		System.out.println();
		System.out.print("The postorder traversal of the given tree is: ");
		tree.postorderTraverseNoRec(tree.root);
//		System.out.println();
		
		// Test if a node exists in the tree
//		System.out.println("Is 5 in the tree? " + tree.search(tree.root, 5).flag);
//		System.out.println("Is 6 in the tree? " + tree.search(tree.root, 6).flag);
		
		
		// Test maxDepth
//		System.out.print("The maximum depth of the given tree is: " + tree.maxDepth(tree.root));
//		System.out.print("The maximum depth of the given tree is: " + tree.maxDepthDC(tree.root));
		
		// Test if heightBalanced
//		System.out.print("Is the given tree height balanced? " + tree.isHeightBalanced2(tree.root));
		
		// Test MaxPathSum
//		System.out.print("The maximum path sum of the given tree is " + tree.maxPathSum(tree.root));
		
		// Test Lowest Common Ancestor
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the value of a node: ");
//		int val1 = sc.nextInt();
//		System.out.print("Enter the value of a node: ");
//		int val2 = sc.nextInt();
//		Node node1 = tree.search(tree.root, val1).node;
//		Node node2 = tree.search(tree.root, val2).node;
//		System.out.print("The lowest common ancestor of Node " + node1.val 
//			+ " and Node " + node2.val + " is: ");
//		System.out.print(tree.lowestCommonAncestor(tree.root, node1, node2).val);
		
		// Test Level Order Traversal
//		System.out.print("The level order traversal of the given tree is: ");
//		tree.levelOrderTraverse(tree.root);
		
		// Test if the given tree a BST
		System.out.print("Is the given tree BST? " + tree.isValidBST(tree.root));
		
	}
	
}
