package binaryTree;

import java.util.Objects;

/**
 * This is the type of tree Node having
 * parent reference.
 */
public class NodeWithParent {
	public int val;
	public NodeWithParent left, right, parent;
	
	public NodeWithParent(int val) {
		this.val = val;
		this.left = this.right = this.parent = null;
	}
	
	public boolean equals(NodeWithParent obj) {
		return (this.val == obj.val); 
	}
}
