package binaryTree;

import java.util.ArrayList;

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
	
	NodeWithParent root;
	
	public BinaryTreeWithParent() {
		root = null;
	}
	
	/**
	 * 1. non-recursively add new node to build the binary tree
	 * @param node
	 * @param val
	 */
	public void insertNoRec(NodeWithParent node, int val) {
		NodeWithParent newNode = new NodeWithParent(val);
		NodeWithParent parentNode = null;
		if (root == null) {
			root = newNode;
		} else {
			NodeWithParent cur = root;
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
	public NodeWithParent searchNoRec(int key) {
		NodeWithParent cur = root;
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
	public NodeWithParent lowestCommonAncestor(NodeWithParent node1, NodeWithParent node2) {
		ArrayList<NodeWithParent> list1 = getPathToRoot(node1);
		ArrayList<NodeWithParent> list2 = getPathToRoot(node2);
		int i, j;
		for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (!list1.get(i).equals(list2.get(j))) {
				return list1.get(i + 1);
//				return list1.get(i).parent;
			}
		}
		return list1.get(i + 1);
	}
	private ArrayList<NodeWithParent> getPathToRoot(NodeWithParent node) {
		ArrayList<NodeWithParent> ret = new ArrayList<NodeWithParent>();
		while (node != null) {
			ret.add(node);
			node = node.parent;
		}
		return ret;
	}
	
}
