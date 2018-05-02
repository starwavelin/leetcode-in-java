package utility;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author benlin
 * UGNoe = UndirectedGraphNode
 */
public class UGNode {
	
	public int label;
	public List<UGNode> neighbors;
	
	public UGNode(int label) {
		this.label = label;
		neighbors = new ArrayList<UGNode>();
	}
}
