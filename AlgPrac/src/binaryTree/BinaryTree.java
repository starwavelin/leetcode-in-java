package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This is the main class of the logic of the BinaryTree app.
 * The methods implemented in this class are as follows:
 * 1. insert(Node node, int val)
 * 2. insertNoRec(Node node, int val)
 * 3. preorderTraverse(Node root)
 * 4. inorderTraverse(Node root)
 * 5. postorderTraverse(Node root)
 * 6. preorderTraverseDC(Node root)
 * 7. preorderTraverseNoRec(Node root)
 * 8. maxDepth(Node root)
 * 9. maxDepthDC(Node root)
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
	
	/**
	 * The non-recursive version of preorderTraverse
	 */
	public void preorderTraverseNoRec(Node root) {
		Stack<Node> stack = new Stack<Node>();
		if (root != null) {
			stack.push(root);
			while (!stack.isEmpty()) {
				root = stack.pop();
				System.out.print(" " + root.val + " ");
				if (root.right != null) {
					stack.push(root.right);
				} 
				if (root.left != null) {
					stack.push(root.left);
				}
			}
		}
	}	
	
	/**
	 * Traverse to find the maxDepth
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(Node root) {
        if (root == null) {
        	return 0;
        }
        int maxDep = findMaxDepth(root, 1);
        return maxDep;
    }
    private int findMaxDepth(Node root, int curDepth) {
    	int leftDepth = curDepth, rightDepth = curDepth;
    	if (root.left != null) {
    		leftDepth = findMaxDepth(root.left, curDepth + 1) ;
    	}
    	if (root.right != null) {
    		rightDepth = findMaxDepth(root.right, curDepth + 1);
    	}
    	return (leftDepth > rightDepth) ? leftDepth : rightDepth;
    }
}
