package binaryTree;

public class BinaryTreeApp {
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Binary Tree Test ***");
		
//		int[] arr = {1, 2, 3};
		int[] arr ={8, 5, 9, 7};
//		int[] arr = {6, 4, 8, 1, 7, 3, 9, 2, 5};
		BinaryTree tree = new BinaryTree();
		for (int i = 0; i < arr.length; i++) {
			tree.insertNoRec(tree.root, arr[i]);
		}
		
		// Test insert, preorder, inorder, postorder
//		System.out.print("The preorder traversal of the given tree is: ");
//		tree.preorderTraverseNoRec(tree.root);
//		System.out.println();		
//		System.out.print("The inorder traversal of the given tree is: ");
//		tree.inorderTraverse(tree.root);
//		System.out.println();
//		System.out.print("The postorder traversal of the given tree is: ");
//		tree.postorderTraverse(tree.root);
//		System.out.println();
		
		// Test maxDepth
//		System.out.print("The maximum depth of the given tree is: " + tree.maxDepth(tree.root));
//		System.out.print("The maximum depth of the given tree is: " + tree.maxDepthDC(tree.root));
		
		// Test if heightBalanced
		System.out.print("Is the given tree height balanced? " + tree.isHeightBalanced(tree.root));
	}
	
}
