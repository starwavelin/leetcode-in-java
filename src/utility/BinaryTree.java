package utility;


public class BinaryTree {
	
	public TreeNode root;

	public BinaryTree() {
		root = null;
	}
	
	public void inorderTraverse(TreeNode root) {
		if (root != null) {
			inorderTraverse(root.left);
			System.out.print(" " + root.val + " ");
			inorderTraverse(root.right);
		}
	}

}
