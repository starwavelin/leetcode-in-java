package utility;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author benlin
 * UGNoe = UndirectedGraphNode
 */
public class UGNode {
	public int val;
	public List<UGNode> neighbors;
	public UGNode(int val) {
		this.val = val;
		neighbors = new ArrayList<UGNode>();
	}
}
