package utility;

import java.util.Objects;

/**
 * TreeNodeP means TreeNodeWithParentReference
 * This is the type of tree Node having parent reference.
 */
public class TreeNodeP {
	public int val;
	public TreeNodeP left, right, parent;
	
	public TreeNodeP(int val) {
		this.val = val;
		this.left = this.right = this.parent = null;
	}
	
	public boolean equals(TreeNodeP obj) {
		return (this.val == obj.val); 
	}
}
