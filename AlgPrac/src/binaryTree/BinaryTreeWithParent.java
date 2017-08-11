package binaryTree;

import java.util.ArrayList;

import utility.TreeNodeP;

/**
 * This is a binary tree where 
 * each node not only has left and right references
 * but also a parent reference
 * @author Guru
 * 
 * 1. insertNoRec(NodeWithParent node, int val)
 * 2. searchNoRec(int key)
 * 3. lowestCommonAncestor(NodeWithParent node1, NodeWithParent node2)
 */
public class BinaryTreeWithParent {
	
	TreeNodeP root;
	
	public BinaryTreeWithParent() {
		root = null;
	}
	
	/**
	 * 1. non-recursively add new node to build the binary tree
	 * @param node
	 * @param val
	 */
	public void insertNoRec(TreeNodeP node, int val) {
		TreeNodeP newNode = new TreeNodeP(val);
		TreeNodeP parentNode = null;
		if (root == null) {
			root = newNode;
		} else {
			TreeNodeP cur = root;
			while (true) {
				parentNode = cur;
				if (val < cur.val) {
					cur = cur.left;
					if (cur == null) {
						parentNode.left = newNode;
						newNode.parent = parentNode;
						return;
					}
				} else {
					cur = cur.right;
					if (cur == null) {
						parentNode.right = newNode;
						newNode.parent = parentNode;
						return;
					}
				}
			} //while
		}//else root != null
	}
	
	/**
	 * 2. Search for a node in the binary tree
	 * @param key
	 * @return
	 */
	public TreeNodeP searchNoRec(int key) {
		TreeNodeP cur = root;
		while (cur.val != key) {
			if (cur == null) {
				return null;
			}
			if (key < cur.val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return cur;
	}
	
	
	/**
	 * 3. get the lowest common ancestor of two nodes in the binary tree
	 * @param node1
	 * @param node2
	 * @return the lowest common ancestor Node
	 */
	public TreeNodeP lowestCommonAncestor(TreeNodeP node1, TreeNodeP node2) {
		ArrayList<TreeNodeP> list1 = getPathToRoot(node1);
		ArrayList<TreeNodeP> list2 = getPathToRoot(node2);
		int i, j;
		for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (!list1.get(i).equals(list2.get(j))) {
				return list1.get(i + 1);
//				return list1.get(i).parent;
			}
		}
		return list1.get(i + 1);
	}
	private ArrayList<TreeNodeP> getPathToRoot(TreeNodeP node) {
		ArrayList<TreeNodeP> ret = new ArrayList<TreeNodeP>();
		while (node != null) {
			ret.add(node);
			node = node.parent;
		}
		return ret;
	}
	
}
