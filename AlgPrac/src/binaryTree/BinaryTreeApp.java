package binaryTree;

public class BinaryTreeApp {
	
	public static void main(String[] args) {
		
		// Test insert, preorder, inorder, postorder
		int[] arr = { 6, 4, 8, 1, 7, 3, 9, 2, 5 };
		BinaryTree tree = new BinaryTree();
		for (int i = 0; i < arr.length; i++) {
			tree.insertNoRec(tree.root, arr[i]);
		}
		tree.preorderTraverse(tree.root);
		System.out.println();
		tree.inorderTraverse(tree.root);
		System.out.println();
		tree.postorderTraverse(tree.root);
		System.out.println();
		
	}
	
}
