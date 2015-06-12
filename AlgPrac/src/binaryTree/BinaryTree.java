package binaryTree;

import java.util.ArrayList;

/**
 * This is the main class of the logic of the BinaryTree app.
 * The methods implemented in this class are as follows:
 * 1. insert(Node node, int val)
 * 2. insertNoRec(Node node, int val)
 * 3. preorderTraverse(Node root)
 * 4. inorderTraverse(Node root)
 * 5. postorderTraverse(Node root)
 * 
 * @author Guru
 */
public class BinaryTree {
	
	Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * insert method can be used to build a binary tree
	 * @param node: a node to be inserted into the binary tree
	 * @param val: the value of the node to be inserted
	 */
	public void insert(Node node, int val) {
		if (root == null) {
			root = new Node(val); 
		} else {
			if (val < node.val) {
				if (node.left == null) {
					node.left = new Node(val);
				} else {
					insert(node.left, val);
				}
			} else {
				if (node.right == null) {
					node.right = new Node(val);
				} else {
					insert(node.right, val);
				}
			}
		}
	}
	
	/**
	 * insert method's non-recursive version
	 * two pointers
	 */
	public void insertNoRec(Node node, int val) {
		Node newNode = new Node(val);
		if (root == null) {
			root = newNode; 
		} else {
			Node cur = root;
			Node parent;
			while (true) {
				parent = cur;
				if (val < cur.val) {
					cur = cur.left;
					if (cur == null) {
						parent.left = newNode;
						return;
					}
				} else {
					cur = cur.right;
					if (cur == null) {
						parent.right = newNode;
						return;
					}
				}
			} //while
		}//else root != null
	}
	
	public void preorderTraverse(Node root) {
		if (root != null) {
			System.out.print(" " + root.val + " ");
			preorderTraverse(root.left);
			preorderTraverse(root.right);
		}
	}
	
	public void inorderTraverse(Node root) {
		if (root != null) {
			inorderTraverse(root.left);
			System.out.print(" " + root.val + " ");
			inorderTraverse(root.right);
		}
	}
	
	public void postorderTraverse(Node root) {
		if (root != null) {
			postorderTraverse(root.left);
			postorderTraverse(root.right);
			System.out.print(" " + root.val + " ");
		}
	}
	
	/**
	 * Use Divide and Conquer to solve preorder traversal
	 * @param root
	 */
	public void preorderTraverseDC(Node root) {
		ArrayList<Integer> ret = traverseDC(root);
		for (int element : ret) {
			System.out.print(" " + element + " ");
		}
	}
	private ArrayList<Integer> traverseDC(Node root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root != null) {
			// Divide
			ArrayList<Integer> left = traverseDC(root.left);
			ArrayList<Integer> right = traverseDC(root.right);
			// Conquer
			ret.add(root.val);
			ret.addAll(left);
			ret.addAll(right);
		}
		return ret;
	}
	
	
	
}
