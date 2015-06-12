package binaryTree;

/**
 * The TreeNode used for binaryTree questions.
 */
public class Node {

	public int val;
	public Node left, right;
	
	public Node(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}
